package com.github.yacchin1205.dump_pepper_info;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aldebaran.qi.AnyObject;
import com.aldebaran.qi.Future;
import com.aldebaran.qi.QiCallback;
import com.aldebaran.qi.QiFunction;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.sdk.QiContext;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.concurrent.RunnableFuture;

import au.com.bytecode.opencsv.CSVWriter;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "DumpPepperInfo";

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHandler = new Handler();

        final QiContext context = QiContext.get(this);

        Button button = (Button) findViewById(R.id.dump);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Future<Session> session = context.getSharedRequirements().getSessionRequirement().satisfy();
                session.then(new QiFunction<AnyObject, Session>() {
                    @Override
                    public Future<AnyObject> onResult(Session session) throws Exception {
                        return session.service(ALMemory.MODULE_NAME);
                    }
                }).then(new QiCallback<AnyObject>() {
                    @Override
                    public void onResult(final AnyObject alMemory) throws Exception {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                storeFile(new ALMemory(alMemory));
                            }
                        }).start();
                    }
                });
            }
        });
    }

    private void storeFile(ALMemory memory) {
        try {
            final String filename = "memory-info.csv";
            CSVWriter writer = new CSVWriter(new OutputStreamWriter(openFileOutput(filename,
                    MODE_PRIVATE), "SJIS"));

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    TextView status = (TextView) findViewById(R.id.status);
                    status.setText("Loading values...");
                }
            });
            List<?> names = memory.getDataListName().get();
            for(Object key : names) {
                Object data = memory.getData(key.toString()).get();
                String[] row = new String[]{key.toString(),
                        data != null ? (data instanceof Void ? "None" : data.toString()) : ""};
                writer.writeNext(row);
                Thread.sleep(10);
            }

            writer.close();
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    TextView status = (TextView) findViewById(R.id.status);
                    status.setText(String.format("File '%s' created. Please pull the file via adb!",
                            filename));
                }
            });
        }catch(final Throwable th) {
            Log.e(TAG, "Error", th);
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    TextView status = (TextView) findViewById(R.id.status);
                    status.setText(ExceptionUtils.getStackTrace(th));
                }
            });
        }
    }
}

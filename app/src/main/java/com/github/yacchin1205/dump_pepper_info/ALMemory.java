package com.github.yacchin1205.dump_pepper_info;

import com.aldebaran.qi.AnyObject;
import com.aldebaran.qi.Future;

public class ALMemory {

    public static final String MODULE_NAME = "ALMemory";

    private AnyObject _module;

    public ALMemory(AnyObject module) {
        this._module = module;
    }



    /**
     * Exits and unregisters the module.
     * 
     * @return  - Void
     */
    public Future<Void> exit() {
        return _module.call(Void.class, "exit");
    }


    /**
     * NAOqi1 pCall method.
     */
    public Future<Object> getPCall() {
        return _module.getProperty(Object.class, "pCall");
    }

    /**
     * NAOqi1 pCall method.
     */
    public Future<Void> setPCall(Object value) {
        return _module.setProperty("pCall", value);
    }


    /**
     * Returns the version of the module.
     * 
     * @return A string containing the version of the module. - String
     */
    public Future<String> version() {
        return _module.call(String.class, "version");
    }


    /**
     * Just a ping. Always returns true
     * 
     * @return returns true - Bool
     */
    public Future<Boolean> ping() {
        return _module.call(Boolean.class, "ping");
    }


    /**
     * Retrieves the module's method list.
     * 
     * @return An array of method names. - List<String>
     */
    public Future<java.util.List> getMethodList() {
        return _module.call(java.util.List.class, "getMethodList");
    }


    /**
     * Retrieves a method's description.
     * 
     * @param methodName The name of the method. - String
     * @return A structure containing the method's description. - Value
     */
    public Future<Object> getMethodHelp(String methodName) {
        return _module.call(Object.class, "getMethodHelp", methodName);
    }


    /**
     * Retrieves the module's description.
     * 
     * @return A structure describing the module. - Value
     */
    public Future<Object> getModuleHelp() {
        return _module.call(Object.class, "getModuleHelp");
    }


    /**
     * Wait for the end of a long running method that was called using 'post'
     * 
     * @param id The ID of the method that was returned when calling the method using 'post' - Int32
     * @param timeoutPeriod The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero. - Int32
     * @return True if the timeout period terminated. False if the method returned. - Bool
     */
    public Future<Boolean> wait(int id, int timeoutPeriod) {
        return _module.call(Boolean.class, "wait", id, timeoutPeriod);
    }


    /**
     * Wait for the end of a long running method that was called using 'post'
     * 
     * @param id The ID of the method that was returned when calling the method using 'post' - Int32
     * @return True if the timeout period terminated. False if the method returned. - Void
     */
    public Future<Void> wait(int id) {
        return _module.call(Void.class, "wait", id);
    }


    /**
     * Returns true if the method is currently running.
     * 
     * @param id The ID of the method that was returned when calling the method using 'post' - Int32
     * @return True if the method is currently running - Bool
     */
    public Future<Boolean> isRunning(int id) {
        return _module.call(Boolean.class, "isRunning", id);
    }


    /**
     * returns true if the method is currently running
     * 
     * @param id the ID of the method to wait for - Int32
     * @return  - Void
     */
    public Future<Void> stop(int id) {
        return _module.call(Void.class, "stop", id);
    }


    /**
     * Gets the name of the parent broker.
     * 
     * @return The name of the parent broker. - String
     */
    public Future<String> getBrokerName() {
        return _module.call(String.class, "getBrokerName");
    }


    /**
     * Gets the method usage string. This summarises how to use the method.
     * 
     * @param name The name of the method. - String
     * @return A string that summarises the usage of the method. - String
     */
    public Future<String> getUsage(String name) {
        return _module.call(String.class, "getUsage", name);
    }


    /**
     * Declares an event to allow future subscriptions to the event
     * 
     * @param eventName The name of the event - String
     * @return  - Void
     */
    public Future<Void> declareEvent(String eventName) {
        return _module.call(Void.class, "declareEvent", eventName);
    }


    /**
     * Declares an event to allow future subscriptions to the event
     * 
     * @param eventName The name of the event - String
     * @param  p2 (None) - String
     * @return  - Void
     */
    public Future<Void> declareEvent(String eventName, String  p2) {
        return _module.call(Void.class, "declareEvent", eventName,  p2);
    }


    /**
     * Gets the value of a key-value pair stored in memory
     * 
     * @param key Name of the value. - String
     * @return The data as an ALValue. This can often be cast transparently into the original type. - Value
     */
    public Future<Object> getData(String key) {
        return _module.call(Object.class, "getData", key);
    }


    /**
     * Gets the value of a key-value pair stored in memory
     * 
     * @param key Name of the value. - String
     * @param  p2 (None) - Int32
     * @return The data as an ALValue. This can often be cast transparently into the original type. - Value
     */
    public Future<Object> getData(String key, int  p2) {
        return _module.call(Object.class, "getData", key,  p2);
    }


    /**
     * Get an object wrapping a signal bound to the given ALMemory event. Creates the event if it does not exist.
     * 
     * @param eventName Name of the ALMemory event - String
     * @return An AnyObject with a signal named "signal" - Object
     */
    public Future<com.aldebaran.qi.AnyObject> subscriber(String eventName) {
        return _module.call(com.aldebaran.qi.AnyObject.class, "subscriber", eventName);
    }


    /**
     * Get data value and timestamp
     * 
     * @param key Name of the variable - String
     * @return A list of all the data key names that contain the given string. - Value
     */
    public Future<Object> getTimestamp(String key) {
        return _module.call(Object.class, "getTimestamp", key);
    }


    /**
     * Get data value and timestamp
     * 
     * @param key Name of the variable - String
     * @return A list of all the data key names that contain the given string. - Value
     */
    public Future<Object> getEventHistory(String key) {
        return _module.call(Object.class, "getEventHistory", key);
    }


    /**
     * Gets a list of all key names that contain a given string
     * 
     * @param filter A string used as the search term - String
     * @return A list of all the data key names that contain the given string. - List<String>
     */
    public Future<java.util.List> getDataList(String filter) {
        return _module.call(java.util.List.class, "getDataList", filter);
    }


    /**
     * Gets the key names for all the key-value pairs in memory
     * 
     * @return A list containing the keys in memory - List<String>
     */
    public Future<java.util.List> getDataListName() {
        return _module.call(java.util.List.class, "getDataListName");
    }


    /**
     * DEPRECATED - Blocks the caller until the value of a key changes
     * 
     * @param key Name of the data. - String
     * @param deprecatedParameter DEPRECATED - this parameter has no effect - Int32
     * @return an array containing all the retrieved data - Value
     */
    public Future<Object> getDataOnChange(String key, int deprecatedParameter) {
        return _module.call(Object.class, "getDataOnChange", key, deprecatedParameter);
    }


    /**
     * Gets a pointer to 32 a bit data item. Beware, the pointer will only be valid during the lifetime of the ALMemory object. Use with care, at initialization, not every loop.
     * 
     * @param key Name of the data. - String
     * @return A pointer converted to int - Unknown
     */
    public Future<Object> getDataPtr(String key) {
        return _module.call(Object.class, "getDataPtr", key);
    }


    /**
     * Gets a list containing the names of all the declared events
     * 
     * @return A list containing the names of all events - List<String>
     */
    public Future<java.util.List> getEventList() {
        return _module.call(java.util.List.class, "getEventList");
    }


    /**
     * Gets the list of all events generated by a given extractor
     * 
     * @param extractorName The name of the extractor - String
     * @return A list containing the names of the events associated with the given extractor - List<String>
     */
    public Future<java.util.List> getExtractorEvent(String extractorName) {
        return _module.call(java.util.List.class, "getExtractorEvent", extractorName);
    }


    /**
     * Gets the values associated with the given list of keys. This is more efficient than calling getData many times, especially over the network.
     * 
     * @param keyList An array containing the key names. - Value
     * @return An array containing all the values corresponding to the given keys. - Value
     */
    public Future<Object> getListData(Object keyList) {
        return _module.call(Object.class, "getListData", keyList);
    }


    /**
     * Gets a list containing the names of all the declared micro events
     * 
     * @return A list containing the names of all the microEvents - List<String>
     */
    public Future<java.util.List> getMicroEventList() {
        return _module.call(java.util.List.class, "getMicroEventList");
    }


    /**
     * Gets a list containing the names of subscribers to an event.
     * 
     * @param name Name of the event or micro-event - String
     * @return List of subscriber names - List<String>
     */
    public Future<java.util.List> getSubscribers(String name) {
        return _module.call(java.util.List.class, "getSubscribers", name);
    }


    /**
     * Gets the storage class of the stored data. This is not the underlying POD type.
     * 
     * @param key Name of the variable - String
     * @return String type: Data, Event, MicroEvent - String
     */
    public Future<String> getType(String key) {
        return _module.call(String.class, "getType", key);
    }


    /**
     * Inserts a key-value pair into memory, where value is an int
     * 
     * @param key Name of the value to be inserted. - String
     * @param value The int to be inserted - Int32
     * @return  - Void
     */
    public Future<Void> insertData(String key, int value) {
        return _module.call(Void.class, "insertData", key, value);
    }


    /**
     * Inserts a key-value pair into memory, where value is an int
     * 
     * @param key Name of the value to be inserted. - String
     * @param value The int to be inserted - Float
     * @return  - Void
     */
    public Future<Void> insertData(String key, float value) {
        return _module.call(Void.class, "insertData", key, value);
    }


    /**
     * Inserts a key-value pair into memory, where value is an int
     * 
     * @param key Name of the value to be inserted. - String
     * @param value The int to be inserted - String
     * @return  - Void
     */
    public Future<Void> insertData(String key, String value) {
        return _module.call(Void.class, "insertData", key, value);
    }


    /**
     * Inserts a key-value pair into memory, where value is an int
     * 
     * @param key Name of the value to be inserted. - String
     * @param value The int to be inserted - Value
     * @return  - Void
     */
    public Future<Void> insertData(String key, Object value) {
        return _module.call(Void.class, "insertData", key, value);
    }


    /**
     * Inserts a list of key-value pairs into memory.
     * 
     * @param list An ALValue list of the form [[Key, Value],...]. Each item will be inserted. - Value
     * @return  - Void
     */
    public Future<Void> insertListData(Object list) {
        return _module.call(Void.class, "insertListData", list);
    }


    /**
     * Publishes the given data to all subscribers.
     * 
     * @param name Name of the event to raise. - String
     * @param value The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information. - Value
     * @return  - Void
     */
    public Future<Void> raiseEvent(String name, Object value) {
        return _module.call(Void.class, "raiseEvent", name, value);
    }


    /**
     * Publishes the given data to all subscribers.
     * 
     * @param name Name of the event to raise. - String
     * @param value The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information. - Value
     * @return  - Void
     */
    public Future<Void> raiseMicroEvent(String name, Object value) {
        return _module.call(Void.class, "raiseMicroEvent", name, value);
    }


    /**
     * Removes a key-value pair from memory
     * 
     * @param key Name of the data to be removed. - String
     * @return  - Void
     */
    public Future<Void> removeData(String key) {
        return _module.call(Void.class, "removeData", key);
    }


    /**
     * Removes a event from memory and unsubscribes any exiting subscribers.
     * 
     * @param name Name of the event to remove. - String
     * @return  - Void
     */
    public Future<Void> removeEvent(String name) {
        return _module.call(Void.class, "removeEvent", name);
    }


    /**
     * Removes a micro event from memory and unsubscribes any exiting subscribers.
     * 
     * @param name Name of the event to remove. - String
     * @return  - Void
     */
    public Future<Void> removeMicroEvent(String name) {
        return _module.call(Void.class, "removeMicroEvent", name);
    }


    /**
     * Subscribes to an event and automaticaly launches the module that declared itself as the generator of the event if required.
     * 
     * @param name The name of the event to subscribe to - String
     * @param callbackModule Name of the module to call with notifications - String
     * @param callbackMethod Name of the module's method to call when a data is changed - String
     * @return  - Void
     */
    public Future<Void> subscribeToEvent(String name, String callbackModule, String callbackMethod) {
        return _module.call(Void.class, "subscribeToEvent", name, callbackModule, callbackMethod);
    }


    /**
     * Subscribes to an event and automaticaly launches the module that declared itself as the generator of the event if required.
     * 
     * @param name The name of the event to subscribe to - String
     * @param callbackModule Name of the module to call with notifications - String
     * @param callbackMethod Name of the module's method to call when a data is changed - String
     * @param  p4 (None) - String
     * @return  - Void
     */
    public Future<Void> subscribeToEvent(String name, String callbackModule, String callbackMethod, String  p4) {
        return _module.call(Void.class, "subscribeToEvent", name, callbackModule, callbackMethod,  p4);
    }


    /**
     * Subscribes to a microEvent. Subscribed modules are notified on theircallback method whenever the data is updated, even if the new value is the same as the old value.
     * 
     * @param name Name of the data. - String
     * @param callbackModule Name of the module to call with notifications - String
     * @param callbackMessage Message included in the notification. This can be used to disambiguate multiple subscriptions. - String
     * @param callbackMethod Name of the module's method to call when a data is changed - String
     * @return  - Void
     */
    public Future<Void> subscribeToMicroEvent(String name, String callbackModule, String callbackMessage, String callbackMethod) {
        return _module.call(Void.class, "subscribeToMicroEvent", name, callbackModule, callbackMessage, callbackMethod);
    }


    /**
     * Informs ALMemory that a module doesn't exist anymore.
     * 
     * @param moduleName Name of the departing module. - String
     * @return  - Void
     */
    public Future<Void> unregisterModuleReference(String moduleName) {
        return _module.call(Void.class, "unregisterModuleReference", moduleName);
    }


    /**
     * Unsubscribes a module from the given event. No further notifications will be received.
     * 
     * @param name The name of the event - String
     * @param callbackModule The name of the module that was given when subscribing. - String
     * @return  - Void
     */
    public Future<Void> unsubscribeToEvent(String name, String callbackModule) {
        return _module.call(Void.class, "unsubscribeToEvent", name, callbackModule);
    }


    /**
     * Unsubscribes from the given event. No further notifications will be received.
     * 
     * @param name Name of the event. - String
     * @param callbackModule The name of the module that was given when subscribing. - String
     * @return  - Void
     */
    public Future<Void> unsubscribeToMicroEvent(String name, String callbackModule) {
        return _module.call(Void.class, "unsubscribeToMicroEvent", name, callbackModule);
    }


    /**
     * Describe a key
     * 
     * @param name Name of the key. - String
     * @param description The description of the event (text format). - String
     * @return  - Void
     */
    public Future<Void> setDescription(String name, String description) {
        return _module.call(Void.class, "setDescription", name, description);
    }


    /**
     * Descriptions of all given keys
     * 
     * @param keylist List of keys. (empty to get all descriptions) - List<String>
     * @return an array of tuple (name, type, description) describing all keys. - Value
     */
    public Future<Object> getDescriptionList(java.util.List<String> keylist) {
        return _module.call(Object.class, "getDescriptionList", keylist);
    }


    /**
     * Add a mapping between signal and event
     * 
     * @param service Name of the service - String
     * @param signal Name of the signal - String
     * @param event Name of the event - String
     * @return  - Void
     */
    public Future<Void> addMapping(String service, String signal, String event) {
        return _module.call(Void.class, "addMapping", service, signal, event);
    }


    /**
     * Add a mapping between signal and event
     * 
     * @param service Name of the service - String
     * @param signal Name of the signal - Map<String String>
     * @return  - Void
     */
    public Future<Void> addMapping(String service, java.util.Map<String,String> signal) {
        return _module.call(Void.class, "addMapping", service, signal);
    }
}


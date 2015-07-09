package it.almaviva.cordovaplugins;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InAppPdf extends CordovaPlugin {
	/**
     * Constructor.
     */
    public InAppPdf() {
    }

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }
    
    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("show")) {
        	JSONObject r = new JSONObject();
        	
        	File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() +"/"+ filename);
			Intent target = new Intent(Intent.ACTION_VIEW);
			target.setDataAndType(Uri.fromFile(file),"application/pdf");
			target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

			Intent intent = Intent.createChooser(target, "Open File");
			try {
    			startActivity(intent);
			} catch (ActivityNotFoundException e) {
    			// No application to view, ask to download one
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("No Viewer");
                builder.setMessage("Download PDF Viewer?");
                builder.setPositiveButton(getString("Okay"),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                Intent innerIntent = new Intent(
                                        Intent.ACTION_VIEW);
                                innerIntent.setData(Uri
                                        .parse("market://details?id=com.adobe.reader"));
                                startActivity(innerIntent);
                            }
                        });
                builder.setNegativeButton("Cancel"), null);
                builder.create().show();
			}
            callbackContext.success(r);
        }
        else {
            return false;
        }
        return true;
    }
}

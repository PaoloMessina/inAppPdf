package it.almaviva.cordovaplugins;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InAppPdf extends CordovaPlugin {

    private Context c;
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
        	JSONObject r = args.getJSONObject(0);
            String targetPath = r.optString("targetPath");
            c = this.cordova.getActivity().getApplicationContext();

            AssetManager assetManager = c.getAssets();

            InputStream in = null;
            OutputStream out = null;
            //File file = new File(c.getFilesDir(), "abc.pdf");
            //File file = new File(targetPath);
            /*try
            {
                in = assetManager.open("abc.pdf");
                out = c.openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

                copyFile(in, out);
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;
            } catch (Exception e)
            {
                Log.e("tag", e.getMessage());
            }*/


        	
        	//file = new File("file://" + c.getFilesDir() + "/abc.pdf");
			Intent target = new Intent(Intent.ACTION_VIEW);
			target.setDataAndType(Uri.parse(targetPath),"application/pdf");
			target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            target.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

			Intent intent = Intent.createChooser(target, "Open File");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			try {
                c.startActivity(intent);
			} catch (ActivityNotFoundException e) {
    			// No application to view, ask to download one
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("No Viewer");
                builder.setMessage("Download PDF Viewer?");
                builder.setPositiveButton("Okay",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                Intent innerIntent = new Intent(
                                        Intent.ACTION_VIEW);
                                innerIntent.setData(Uri
                                        .parse("market://details?id=com.adobe.reader"));
                                innerIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                InAppPdf.this.c.startActivity(innerIntent);
                            }
                        });
                //builder.setNegativeButton("Cancel"), null);
                builder.create().show();
			}
            callbackContext.success(r);
        }
        else {
            return false;
        }
        return true;
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }
}

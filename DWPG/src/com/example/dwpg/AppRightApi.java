package com.example.dwpg;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.text.TextUtils;

import com.developergarden.appmonitor.AppMonitor;

public class AppRightApi extends CordovaPlugin {


	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callback) throws JSONException
	{
		if (action.equals("sendNow"))
		{
			AppMonitor.sendNow();
			callback.success();
			
			return true;
		}
		else if (action.equals("reportBug"))
		{
			if (args != null && args.length() > 0)
			{
				String msg = args.getString(0);
				if (!TextUtils.isEmpty(msg))
				{
					AppMonitor.reportBug(msg);
					return true;
				}
			}
		}
		else if (action.equals("reportException"))
		{
			if (args != null && args.length() > 0)
			{
				String errMessage = args.getString(0);
				if (!TextUtils.isEmpty(errMessage))
				{
					AppMonitor.reportException(new Exception(errMessage));
					return true;
				}
			}
		}
		else if (action.equals("addMarker"))
		{
			if (args != null && args.length() > 0)
			{
				String msg = args.getString(0);
				if (!TextUtils.isEmpty(msg))
				{
					AppMonitor.addMarker(msg);
					return true;
				}
			}
		}
		else if (action.equals("setLocationTrackingState"))
		{
			if (args != null && args.length() > 0)
			{
				try {
					String stateStr = args.getString(0);
					if (!TextUtils.isEmpty(stateStr))
					{
						boolean state = stateStr.equals("true")?true:false;
						AppMonitor.setLocationTrackingState(state);
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
}

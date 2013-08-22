package com.example.dwpg;

import com.developergarden.appmonitor.AppMonitor;
import com.developergarden.appmonitor.LifeCyclePhase;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class App extends Application{
	
  public static Context mContext;	
	
  @Override
  public void onCreate() {
    super.onCreate();
    mContext = this.getApplicationContext();
    startAppMonitor();
  }
  
  public static void startAppMonitor()
  {
	  try{
	  AppMonitor.start(mContext, "78b089894f4984d4c2b430487556a942-4959c2c5c5cdf835b60dfa2b9bf72948-5b1cc3e50714b0f6e10f083a55248917", LifeCyclePhase.DEVELOPMENT);
	  }
	  catch (Exception e){
		  Log.v("developer_garden", "startAppMonitor: Exception: " + e.getMessage());
	  }
  }
}
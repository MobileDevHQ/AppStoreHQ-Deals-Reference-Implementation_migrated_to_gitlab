package com.appstorehq.android.deals.implementation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.appstorehq.android.deals.api.AppStoreHQDealsController;

public class ReferenceImplementation extends Activity {
    
    public  static final long sAppStoreHQAppId = 60;
    private static final String LOG_TAG = "ReferenceImplementation";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView( R.layout.main );
    }
    
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.main_menu, menu );
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected( MenuItem item ) {

        switch ( item.getItemId() ) {
            case R.id.main_menu_deal_item:

                Log.d( LOG_TAG, "Starting the AppStoreHQDealsController" );
                
                /**
                 *  To kick off the Deals dialog flow call:
                 *  
                 *    AppStoreHQDealsController.processRebate( Context context, long appStoreHQAppId );
                 *  
                 *  Arguments:
                 *  
                 *    Context context:
                 *      The running context of this activity.  Just pass the
                 *      running instance of the current activity, ie:
                 *        'ReferenceImplementation.this'
                 *      Of course, if you're still in scope ( like we are here )
                 *      you can just use 'this'.
                 *      
                 *    long appStoreHQAppId:
                 *      The application id of your application on AppStoreHQ. 
                 *      You can find this from the URL of your application on AppStoreHQ.
                 *      For example, AppESP's url is:
                 *        http://www.appstorehq.com/appespbyappstorehq-android-334556/app
                 *      and it's app id is 334556
                 */
                
                AppStoreHQDealsController.processRebate(
                        ReferenceImplementation.this,
                        ReferenceImplementation.sAppStoreHQAppId );
                
                break;
        }

        return false;
    }
}
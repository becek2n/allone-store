package store.allonstore;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.Global;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity 
        implements ContactsList.NavigationDrawerCallbacks {
	//implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    
    private ContactsList mContact;

    private LayoutInflater mInflater;
    
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    
    private ExpandableListView mListView;
    private DrawerLayout mDrawerLayout;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mNavigationDrawerFragment = (NavigationDrawerFragment)
        		//         getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        //mTitle = getTitle();

        // Set up the drawer.
        //mNavigationDrawerFragment.setUp(
        		//        R.id.navigation_drawer,
        		//        (DrawerLayout) findViewById(R.id.drawer_layout));
        
        mContact = (ContactsList)
		         getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
    	mTitle = getTitle();

    	// Set up the drawer.
    	mContact.setUp(
		        R.id.navigation_drawer,
		        (DrawerLayout) findViewById(R.id.drawer_layout));
    	
    	mListView = (ExpandableListView)findViewById(R.id.listView);
    	mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
    
    	//event click children
    	mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
    	    @Override
    	    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
    	    	
    	    	String strChild = parent.getExpandableListAdapter().getChild(groupPosition, childPosition).toString();
    	    	onNavigationDrawerItemSelected(childPosition, strChild);
    	    	return true;
    	    }
    	});
    	
    	
    }
    
    @Override
    public void onNavigationDrawerItemSelected(int position, String strChild) {
    	Fragment objFragment = null;
    	switch(position){
    	case 0:
    		objFragment = new ContactsList();
    		break;
    	//case 1:
    		//objFragment = new GroupList();
    		//break;
    	default:
    		break;
    	}
    	
    	    	
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction()
        //        .replace(R.id.container, objFragment)
        //        .commit();
        objFragment = new PlaceholderFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container, objFragment)
                .commit();
        
        mListView.setItemChecked(position, true);
        onSectionAttached(strChild);
    }

    public void onSectionAttached(String title) {
        mTitle = title;
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //if (!mNavigationDrawerFragment.isDrawerOpen()) {
    	if (!mContact.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
       

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        //@Override
        //public void onAttach(Activity activity) {
        //    super.onAttach(activity);
        //    CharSequence str = "s";
        //    ((MainActivity) activity).onSectionAttached(
        //            getArguments().getString(ARG_SECTION));
        //}
    }

}

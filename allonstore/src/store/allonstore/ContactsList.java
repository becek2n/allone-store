package store.allonstore;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.preference.PreferenceManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;
import store.allonstore.Group;
import store.allonstore.CustomExpandableListAdapter;
import store.allonstore.NavigationDrawerFragment.NavigationDrawerCallbacks;


public class ContactsList extends Fragment {
	
	public ContactsList() {}
	
	ExpandableListView listView;
	Context thisContext;
	
	private NavigationDrawerCallbacks mCallbacks;

    /**
     * Helper component that ties the action bar to the navigation drawer.
     */
    private ActionBarDrawerToggle mDrawerToggle;

    private DrawerLayout mDrawerLayout;
    
    private View mFragmentContainerView;
   
    private boolean mFromSavedInstanceState;
    private boolean mUserLearnedDrawer;
    private int mCurrentSelectedPosition = 0;
    private ListView mDrawerListView;
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
    
	 @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);
         
         // Expandable list view
         
         listView = (ExpandableListView)rootView.findViewById(R.id.listView);
         thisContext = getContext();
         ArrayList<Group> groups = prepareData();
         final CustomExpandableListAdapter adapter = new CustomExpandableListAdapter(thisContext, groups);
         listView.setAdapter(adapter);
         
         //event click header
         //listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
         //	    @Override
        //	    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        //	        Group group = (Group) adapter.getGroup(groupPosition);
        //	 
        //	        Toast
        //	            .makeText(thisContext, group.mName, Toast.LENGTH_SHORT)
        //	            .show();
        //	 
        //	        return false;
        //	    }
        //	});
        	//event click childer
    	listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
    	    @Override
    	    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
    	        String child = (String) adapter.getChild(groupPosition, childPosition);
    	 
    	        Toast
    	            .makeText(thisContext, child, Toast.LENGTH_SHORT)
    	            .show();
    	 
    	        return false;
    	    }
    	});
         
         return rootView;
     }
	 
	 public ArrayList<Group> prepareData() {
    	 
	        Group group1 = new Group("Allone");
	        group1.children.add("Berita Utama");
	        group1.children.add("Most Popular");
	        group1.children.add("Most Commented");
	     
	        Group group2 = new Group("Allone News");
	        group2.children.add("Fokus");
	        group2.children.add("Infografis");
	        group2.children.add("Berita");
	        group2.children.add("Foto News");
	        group2.children.add("Daerah");
	        group2.children.add("Internasional");
	        group2.children.add("Kolom");
	        group2.children.add("Wawancara");
	        group2.children.add("Tokoh");
	        
	        Group group3 = new Group("Allone Finance");
	        group3.children.add("Topik Terhangat");
	        group3.children.add("Ekonomi Bisnis");
	        group3.children.add("Finansial");
	        group3.children.add("Properti");
	        group3.children.add("Energi");
	        group3.children.add("Industro");
	        group3.children.add("Peluang Usaha");
	        group3.children.add("Perancangan Keuangan");
	        group3.children.add("Konsultasi");
	     
	        Group group4 = new Group("Allone Hot");
	        group4.children.add("Hot Topics");
	        group4.children.add("Celeb of The Month");
	        group4.children.add("Celeb");
	        group4.children.add("Music");
	        group4.children.add("Movie");
	        group4.children.add("Art & Culture");
	        group4.children.add("KROP");
	        group4.children.add("Gallery");
	        
	        Group group5 = new Group("Allone Net");
	        group5.children.add("Inet Highlights");
	        group5.children.add("Cyberlife");
	        group5.children.add("Consumer");
	        group5.children.add("Games");
	        group5.children.add("Security");
	        group5.children.add("Telco");
	        group5.children.add("Fotoshop News");
	        group5.children.add("Bussines");
	        group5.children.add("Law and Plicy");
	        group5.children.add("Ngopi");
	        
	        Group group6 = new Group("Allone Sport");
	        group6.children.add("Basket");
	        group6.children.add("Moto GP");
	        group6.children.add("F1");
	        group6.children.add("Raket");
	        group6.children.add("Sport Lainnya");
	        
	        Group group7 = new Group("Sepakbola");
	        group7.children.add("Sport Highlights");
	        group7.children.add("Italia");
	        group7.children.add("Inggris");
	        group7.children.add("Spanyol");
	        group7.children.add("Indonesia");
	        
	        Group group8 = new Group("Allone Oto");
	        group8.children.add("Oto Fokus");
	        group8.children.add("Berita");
	        group8.children.add("Mobil");
	        group8.children.add("Motor");
	        group8.children.add("Modifikasi");
	        group8.children.add("Tips & Trik Oto");
	        group8.children.add("Komunitas");
	        group8.children.add("Oto Test");
	        group8.children.add("Galeri");
	        group8.children.add("Konsultasi");
	        
	        Group group9 = new Group("Allone Food");
	        group9.children.add("Ulasan Khusus");
	        group9.children.add("Kabar Kuliner");
	        group9.children.add("Tempat Makan");
	        group9.children.add("Halal");
	        group9.children.add("Makanan Anak");
	        group9.children.add("Fot");
	        group9.children.add("Konsultasi");
	        
	        Group group10 = new Group("Allone Healt");
	        group10.children.add("Ulasan Khas");
	        group10.children.add("Berita Sehat");
	        group10.children.add("Seks Sehat");
	        group10.children.add("Diet");
	        group10.children.add("Ibu dan Anak");
	        group10.children.add("Konsultasi");
	        
	        Group group11 = new Group("Allone Travel");
	        group11.children.add("Travel Highlights");
	        group11.children.add("Travel News");
	        group11.children.add("Travel Tips");
	        group11.children.add("Destination");
	        
	        Group group12 = new Group("Wolipop");
	        group12.children.add("Lipsus");
	        group12.children.add("Fashion");
	        group12.children.add("Hijab");
	        group12.children.add("Beauty");
	        group12.children.add("Photos");
	        group12.children.add("Sale and Shop");
	        group12.children.add("Entertainment");
	        group12.children.add("Love and Sex");
	        group12.children.add("Wedding");
	        group12.children.add("Hone and Living");
	        group12.children.add("Ask The Expert");
	        
	        Group group13 = new Group("More");
	        group13.children.add("Info Sepakbola");
	        group13.children.add("Jadwal Bioskop");
	        group13.children.add("Info Kurs");
	        group13.children.add("Bookmark");
	        
	        ArrayList<Group> groups = new ArrayList<Group>();
	        groups.add(group1);
	        groups.add(group2);
	        groups.add(group3);
	        groups.add(group4);
	        groups.add(group5);
	        groups.add(group6);
	        groups.add(group7);
	        groups.add(group8);
	        groups.add(group9);
	        groups.add(group10);
	        groups.add(group11);
	        groups.add(group12);
	        groups.add(group13);
	        return groups;
    }
	    
	 @SuppressLint("NewApi")
	private void setGroupIndicatorToRight() {
		/* Get the screen width */
		DisplayMetrics dm = new DisplayMetrics();
		//((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);
		((WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE))
		  .getDefaultDisplay().getMetrics(dm);
		//getWindowManager().getDefaultDisplay().getMetrics(dm);
		int width = dm.widthPixels;

		listView.setIndicatorBounds(width - getDipsFromPixel(35), width
				- getDipsFromPixel(5));
	}
	 // Convert pixel to dip
	public int getDipsFromPixel(float pixels) {
		// Get the screen's density scale
		final float scale = getResources().getDisplayMetrics().density;
		// Convert the dps to pixels, based on density scale
		return (int) (pixels * scale + 0.5f);
	}
	
	public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the navigation drawer and the action bar app icon.
        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),                    /* host Activity */
                mDrawerLayout,                    /* DrawerLayout object */
                R.drawable.ic_drawer,             /* nav drawer image to replace 'Up' caret */
                R.string.navigation_drawer_open,  /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close  /* "close drawer" description for accessibility */
        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (!isAdded()) {
                    return;
                }

                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isAdded()) {
                    return;
                }

                if (!mUserLearnedDrawer) {
                    // The user manually opened the drawer; store this flag to prevent auto-showing
                    // the navigation drawer automatically in the future.
                    mUserLearnedDrawer = true;
                    SharedPreferences sp = PreferenceManager
                            .getDefaultSharedPreferences(getActivity());
                    sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).commit();
                }

                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };

        // If the user hasn't 'learned' about the drawer, open it to introduce them to the drawer,
        // per the navigation drawer design guidelines.
        if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
            mDrawerLayout.openDrawer(mFragmentContainerView);
        }

        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
	
	private ActionBar getActionBar() {
        return ((ActionBarActivity) getActivity()).getSupportActionBar();
    }

	public static interface NavigationDrawerCallbacks {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        void onNavigationDrawerItemSelected(int position, String strChild);
    }
	
	private void showGlobalContextActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setTitle(R.string.app_name);
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (item.getItemId() == R.id.action_example) {
            Toast.makeText(getActivity(), "Example action.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
	
	@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // If the drawer is open, show the global app actions in the action bar. See also
        // showGlobalContextActionBar, which controls the top-left area of the action bar.
        if (mDrawerLayout != null && isDrawerOpen()) {
            inflater.inflate(R.menu.global, menu);
            showGlobalContextActionBar();
        }
        super.onCreateOptionsMenu(menu, inflater);
    }
	
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Forward the new configuration the drawer toggle component.
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
	
	@Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_SELECTED_POSITION, mCurrentSelectedPosition);
    }
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallbacks = (NavigationDrawerCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement NavigationDrawerCallbacks.");
        }
    }
    
    private void selectItem(int position, String strChild) {
        mCurrentSelectedPosition = position;
        if (mDrawerListView != null) {
            mDrawerListView.setItemChecked(position, true);
        }
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer(mFragmentContainerView);
        }
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected(position, strChild);
        }
    }
    
    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }
    
    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen(mFragmentContainerView);
    }
}

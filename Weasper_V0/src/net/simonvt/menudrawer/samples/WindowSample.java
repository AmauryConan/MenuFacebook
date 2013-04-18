package net.simonvt.menudrawer.samples;



import com.fragment.BodyFragment;
import com.fragment.ExampleFragment;
import com.fragment.fastFragment;
import com.fragment.ironFragment;
import com.fragment.wolvFragment;
import com.tabactivity.BodyActivity;
import com.tabactivity.ExempleFragmentActivity;
import com.tabactivity.FastActivity;
import com.tabactivity.IronActivity;
import com.tabactivity.WolvActivity;

import net.simonvt.menudrawer.MenuDrawer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.TabHost.OnTabChangeListener;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class WindowSample extends FragmentActivity  {

	private Fragment mContent;
	@SuppressWarnings("deprecation")
	LocalActivityManager mlam = new LocalActivityManager(this, false);
	
	public WindowSample() {
		super();
	}

    private static final String STATE_MENUDRAWER = "net.simonvt.menudrawer.samples.WindowSample.menuDrawer";
    private static final String STATE_ACTIVE_VIEW_ID = "net.simonvt.menudrawer.samples.WindowSample.activeViewId";

    private MenuDrawer mMenuDrawer;


    private int mActiveViewId;

    @Override
    public void onCreate(Bundle inState) {
        super.onCreate(inState);
      
        if (inState != null) {
            mActiveViewId = inState.getInt(STATE_ACTIVE_VIEW_ID);
        }
      
        mMenuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_CONTENT); //reglage pour slide avec l'action bar ou sans (MenuDrawer.MENU_DRAG_CONTENT)
       // mMenuDrawer.setContentView(R.layout.activity_windowsample);
        mMenuDrawer.setContentView(R.layout.activity_home_principal);
        mMenuDrawer.setMenuView(R.layout.menu_scrollview);
        
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            getActionBar().setDisplayHomeAsUpEnabled(true); 
            getActionBar().hide(); //Cache l'actionbar
        }

       

        findViewById(R.id.findsomeone).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMenuDrawer.setActiveView(v);
				
		        mMenuDrawer.closeMenu();
		        mActiveViewId = v.getId();
		        
		        Fragment newContent = null;
				int NBtab = -1;
				
				newContent = new com.fragment.ExampleFragment();
				NBtab = 0;
				
				if (newContent != null)
					switchFragment(newContent,NBtab);
			}
		});
        findViewById(R.id.Perception).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMenuDrawer.setActiveView(v);
				mMenuDrawer.closeMenu();
		        mActiveViewId = v.getId();
		        
		        Fragment newContent = null;
				int NBtab = -1;
				newContent = new com.fragment.wolvFragment();

				NBtab = 1;
				if (newContent != null)
					switchFragment(newContent,NBtab);
        
		       		
			}
		});
        findViewById(R.id.Questions).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMenuDrawer.setActiveView(v);
				mMenuDrawer.closeMenu();
		        mActiveViewId = v.getId();
		        

		        Fragment newContent = null;
				int NBtab = -1;
				newContent = new com.fragment.ironFragment();

				NBtab = 2;
				if (newContent != null)
					switchFragment(newContent,NBtab);
				
			}
		});
        findViewById(R.id.Invitations).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMenuDrawer.setActiveView(v);
				mMenuDrawer.closeMenu();
		        mActiveViewId = v.getId();
		        Fragment newContent = null;
				int NBtab = -1;
				newContent = new com.fragment.fastFragment();

				NBtab = 3;
				if (newContent != null)
					switchFragment(newContent,NBtab);
				
			}
		});
        findViewById(R.id.Myprofil).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMenuDrawer.setActiveView(v);
				mMenuDrawer.closeMenu();
		        mActiveViewId = v.getId();
		        Fragment newContent = null;
				int NBtab = -1;
				newContent = new com.fragment.ironFragment();
				NBtab = 4;
				if (newContent != null)
					switchFragment(newContent,NBtab);
				
			}
		});
        findViewById(R.id.Howitworks).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMenuDrawer.setActiveView(v);
				mMenuDrawer.closeMenu();
		        mActiveViewId = v.getId();
		        
			        Fragment newContent = null;
					int NBtab = -1;
					newContent = new com.fragment.ExampleFragment();
					NBtab = -1;
					if (newContent != null)
						switchFragment(newContent,NBtab);
			}
		});
        findViewById(R.id.Settings).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMenuDrawer.setActiveView(v);
				mMenuDrawer.closeMenu();
		        mActiveViewId = v.getId();
				addFragment(new ExampleFragment(), false, FragmentTransaction.TRANSIT_NONE);
			}
		});
        
        findViewById(R.id.btnslidemenu).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMenuDrawer.toggleMenu();

			}
		});

        /***TEST TABBAR***/
        LocalActivityManager mlam = new LocalActivityManager(this, false);
         final TabHost tabHost = (TabHost) findViewById(R.id.tabhostmomo);
        mlam.dispatchCreate(inState);
        tabHost.setup(mlam);
        TabHost.TabSpec spec;
        Intent intent;


        intent = new Intent().setClass(this, BodyActivity.class);
        spec = tabHost.newTabSpec("thirdtab").setIndicator("").setContent(intent);
        tabHost.addTab(spec);
                
        intent = new Intent().setClass(this, WolvActivity.class);
        spec = tabHost.newTabSpec("wolvtab").setIndicator("").setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, IronActivity.class);
        spec = tabHost.newTabSpec("irontab").setIndicator("").setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, FastActivity.class);
        spec = tabHost.newTabSpec("fasttab").setIndicator("").setContent(intent);
        tabHost.addTab(spec);
        
        tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.buttonsearchoff);
        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.buttonperceptionoff);
        tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.buttonquestionoff);
        tabHost.getTabWidget().getChildAt(3).setBackgroundResource(R.drawable.buttoninviteoff);
        
        // set default tab
        tabHost.setCurrentTabByTag("firsttab");

        
		tabHost.setOnTabChangedListener(new OnTabChangeListener(){
			@Override
			public void onTabChanged(String tabId) { //tabID =  wolvtab || irontab || firsttab ....  
				
				/**Gestion couleur tab selectioné**/
				 	tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.buttonsearchoff);
			        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.buttonperceptionoff);
			        tabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.buttonquestionoff);
			        tabHost.getTabWidget().getChildAt(3).setBackgroundResource(R.drawable.buttoninviteoff);
						
			        if (tabHost.getCurrentTab() == 0)
			        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.buttonsearchon);
			        else if (tabHost.getCurrentTab() == 1)
			        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.buttonperceptionon);
			        else if (tabHost.getCurrentTab() == 2)
				    tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.buttonquestionon);
			        else if (tabHost.getCurrentTab() == 3)
				    tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundResource(R.drawable.buttoninviteon);
						
			        //MET LA TRANSPARENCE Dans le tab content
						Fragment mContenttransparent = new com.fragment.TransparentFragment();
						getSupportFragmentManager()
						.beginTransaction()		
						.replace(android.R.id.tabcontent, mContenttransparent)
						.commit();
						
			}});
        
        
        // This will animate the drawer open and closed until the user manually drags it. Usually this would only be
        // called on first launch.
        mMenuDrawer.peekDrawer();
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        mMenuDrawer.restoreState(inState.getParcelable(STATE_MENUDRAWER));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(STATE_MENUDRAWER, mMenuDrawer.saveState());
        outState.putInt(STATE_ACTIVE_VIEW_ID, mActiveViewId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           case android.R.id.home:
                mMenuDrawer.toggleMenu();
               return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        final int drawerState = mMenuDrawer.getDrawerState();
        if (drawerState == MenuDrawer.STATE_OPEN || drawerState == MenuDrawer.STATE_OPENING) {
            mMenuDrawer.closeMenu();
            return;
        }

        super.onBackPressed();
    }
      
	public void switchFragment(Fragment fragment,int numeroTab) {
		TabHost tabHost = (TabHost) findViewById(R.id.tabhostmomo);
		if (numeroTab != -1)
		{
		tabHost.setCurrentTab(numeroTab);	
		 mMenuDrawer.closeMenu();
		}
		else{
		/*	mContent = fragment;
			getSupportFragmentManager()
			.beginTransaction()		
			.replace(android.R.id.tabcontent, fragment)
			.commit();*/

		}
	}
	
    void addFragment(Fragment fragment, boolean addToBackStack, int transition) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(android.R.id.tabcontent, fragment);
        ft.setTransition(transition);
        if (addToBackStack)
            ft.addToBackStack(null);
        ft.commit();
    }
	
  
    

	
    
}

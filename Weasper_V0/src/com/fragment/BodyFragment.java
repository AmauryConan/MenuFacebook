package com.fragment;

import com.adapter.ListSearchAdapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import net.simonvt.menudrawer.samples.R;

//extended from compatibility Fragment for pre-HC fragment support
public class BodyFragment extends ListFragment {
	
	private ListSearchAdapter adapter;
	private EditText inputSearch;
	private ListView lv;
	private Button random;
	private Button AZ;
	private Button frequency;
	 

   // onCreate
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   	}

   // onActivityCreated
   @Override
   public void onActivityCreated(Bundle savedInstanceState) {
      super.onActivityCreated(savedInstanceState);
      
      random = (Button) getView().findViewById(R.id.btnrandom); 
      AZ = (Button) getView().findViewById(R.id.btnaz);
      frequency = (Button) getView().findViewById(R.id.btnfrequency);
      lv = (ListView) getView().findViewById(android.R.id.list);
      
      	  String[] values = new String[] { "Android", "iPhone", "WindowsMobile","Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X","Linux", "OS/2" };
      	  adapter = new ListSearchAdapter(getActivity(), values);
          lv.setAdapter(adapter);

          
          inputSearch = (EditText) getView().findViewById(R.id.editText_search);
          inputSearch.addTextChangedListener(new TextWatcher() {

              @Override
              public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
            	  // When user changed the Text
            	  BodyFragment.this.adapter.getFilter().filter(cs);
              	   }
            	  @Override
                  public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) {
            		  	// TODO Auto-generated method stub
            	  }

                  @Override
                  public void afterTextChanged(Editable arg0) {
                  // TODO Auto-generated method stub
                  }

              });
          
          random.setOnClickListener(new View.OnClickListener() {
  			@Override
  			public void onClick(View v) {
  				
  			}
  		});
          
          AZ.setOnClickListener(new View.OnClickListener() {
  			@Override
  			public void onClick(View v) {
  				
  			}
  		});
          
          frequency.setOnClickListener(new View.OnClickListener() {
  			@Override
  			public void onClick(View v) {
  				
  			}
  		});
          
    	  }

    	  @Override
    	  public void onListItemClick(ListView l, View v, int position, long id) {
    	    // Do something with the data

    	  }
    	  

   
   // onCreateView
   @Override
   public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.activity_search,container,false);
      
     
      
      return view;
   }
   
   

   } 
   


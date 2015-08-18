package com.mulwatech.k_farmer;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import Fragments.CategorySelector;
import Fragments.Chat;
import Fragments.DealerRegistration;
import Fragments.Dealerfilter;
import Fragments.Expertfilter;
import Fragments.FarmerRegistration;
import Fragments.Sale;
import Fragments.Userselection;


public class main_page extends AppCompatActivity {

    private ListView Drawerlist;
    private DrawerLayout drawerLayout;
    private ArrayAdapter<String> adapter;
    private ActionBarDrawerToggle drawerToggle;
    private String drawerTitle;

    //fragments

    private final Userselection user = new Userselection();
    private final Sale sale = new Sale();
    private final CategorySelector categoryselector = new CategorySelector();
    private final Chat chat = new Chat();
    private final Expertfilter expertfilter = new Expertfilter();
    private final Dealerfilter dealerfilter = new Dealerfilter();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Drawerlist = (ListView) findViewById(R.id.navList);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerTitle = getTitle().toString();

        addmenu();
        setUpDrawer();





    }
    public void addmenu(){
        final String[] Menus = {"Registration", "Sale", "On Sale", "Locate Dealer","Chat with Experts","Locate an Expert"};
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Menus);
        Drawerlist.setAdapter(adapter);
        Drawerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawer(Drawerlist);
//                Toast.makeText(getApplicationContext(), Menus[position], Toast.LENGTH_SHORT).show();
                selected(position);

                CategorySelector fragment = null;

                switch (Menus[position]) {

                    case "Registration":
//                        Toast.makeText(getApplicationContext(),"open Registration fragment",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content,user)
                                .commit();
                        break;
                    case "Sale":
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content,sale)
                                .commit();
                        break;
                    case "On Sale":
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content,categoryselector )
                                .commit();

                        break;
                    case "Best Practices":
                        Toast.makeText(getApplicationContext(), "BEST PRACTICES NOT  AVAILABLE NEEDS INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                        break;
                    case "Chat with Experts":
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content, chat)
                                .commit();
                        break;
                    case "Locate an Expert":
                        Toast.makeText(getApplicationContext(), "search expert", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content, expertfilter)
                                .commit();
                        break;
                    case "Locate Dealer":
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content, dealerfilter)
                                .commit();
                        break;

                    default:
                        break;
                }


            }

            public void selected(int position) {
                Drawerlist.setItemChecked(position, true);
                setTitle(Menus[position]);
            }

            public void setTitle(String title) {
                getSupportActionBar().setTitle(title);

            }
        });
    }



    public void setUpDrawer(){
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer ){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
                getSupportActionBar().setTitle("K-FARMER");

            }

            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();

            }
        };

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }


}

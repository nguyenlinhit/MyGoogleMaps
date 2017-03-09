package com.nguyenlinh.android.mygooglemaps.app;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.nguyenlinh.android.mygooglemaps.adapter.HotelAdapter;
import com.nguyenlinh.android.mygooglemaps.database.SQLDatasource;
import com.nguyenlinh.android.mygooglemaps.fragment.ClothesFragment;
import com.nguyenlinh.android.mygooglemaps.fragment.CoffeeFragment;
import com.nguyenlinh.android.mygooglemaps.fragment.GasStationFragment;
import com.nguyenlinh.android.mygooglemaps.fragment.HomeFragment;
import com.nguyenlinh.android.mygooglemaps.fragment.HotelFragment;
import com.nguyenlinh.android.mygooglemaps.fragment.MarketFragment;
import com.nguyenlinh.android.mygooglemaps.fragment.RestaurantFragment;
import com.nguyenlinh.android.mygooglemaps.fragment.SmartPhoneFragment;
import com.nguyenlinh.android.mygooglemaps.model.Hotel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private View navHeader;
    private FloatingActionButton fab;


    //Index to indentify current nav menu item
    public static int navItemIndex = 0;

    //Tags used to attach the fragment
    private static final String TAG_HOME = "home";
    private static final String TAG_RESTAURANT = "restaurant";
    private static final String TAG_HOTEL = "hotel";
    private static final String TAG_MARKET = "market";
    private static final String TAG_SMARTPHONE = "smartphone";
    private static final String TAG_CLOTHES = "clothes";
    private static final String TAG_COFFEE = "coffee";
    private static final String TAG_GASSTATION = "gasstation";
    private static  String CURRENT_TAG = TAG_HOME;

    //toolbar titles respected to selected nav menu item
    private String[] activitiTitles;

    //flag to load hone fragment when presses back key
    private  boolean shoudLoadHomeFragOnBackPress = true;
    private Handler mHandler;
    SQLDatasource db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_alternative).setOnClickListener(this);
        addControls();
        addEvents();
        //Khởi tạo Toolbar và thiết lập nó như một actionbar
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        //Khởi tạo NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navHeader = navigationView.getHeaderView(0);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        //Hiển thị tiêu đề của menu từ String resources
        activitiTitles = getResources().getStringArray(R.array.nav_item_activity_titles);
        //Google Maps
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(this);

        setUpNavigationView();


        mHandler = new Handler();


        if (savedInstanceState == null){
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragMent();
        }


    }

    private void loadHomeFragMent() {
        //chọn nav menu item
        selectedNavMenu();

        //thay đổi tên appbar
        setToolbarTitles();

        if(getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null){
            drawerLayout.closeDrawers();

            //ẩn hoặc hiện fab button
            toggleFab();
            return;
        }

        //sử dụng Runable khi dữ liêu quá lớn
        Runnable mPenDingRunnable = new Runnable() {
            @Override
            public void run() {
                //cập nhật nội dung
                Fragment fragment = getHomeFragMent();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame,fragment,CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        //nếu mPendingRunnable khác rỗng,sau đó thêm vào thông điệp hàng đợi
        if (mPenDingRunnable != null){
            mHandler.post(mPenDingRunnable);
        }

        //ẩn hoặc hiện fab button
        toggleFab();
        //đóng naviagation khi nhấp chuột
        drawerLayout.closeDrawers();
        //làm tươi toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragMent() {
        switch (navItemIndex){
            //home
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            //Nhà Hàng
            case 1:
                RestaurantFragment restaurantFragment = new RestaurantFragment();
                return restaurantFragment;
            //Khách Sạn
            case 2: HotelFragment hotelFragment = new HotelFragment();
                return hotelFragment;
            //Chợ
            case 3:
                MarketFragment marketFragment = new MarketFragment();
                return marketFragment;
            //Shop Điện Thoại
            case 4:
                SmartPhoneFragment smartPhoneFragment = new SmartPhoneFragment();
                return smartPhoneFragment;
            //Shop Quần Áo
            case 5:
                ClothesFragment clothesFragment = new ClothesFragment();
                return clothesFragment;
            //Quán Cà Phê
            case 6:
                CoffeeFragment coffeeFragment = new CoffeeFragment();
                return coffeeFragment;
            //TRạm Xăng
            case 7:
                GasStationFragment gasStationFragment = new GasStationFragment();
                return gasStationFragment;
            default:
                return new HomeFragment();
        }

    }


    //ẩn hoăc hiện fab
    private void toggleFab() {
        if(navItemIndex == 0){
            fab.show();
        }else {
            fab.hide();
        }
    }

    private void setToolbarTitles() {
        getSupportActionBar().setTitle(activitiTitles[navItemIndex]);
    }

    //Lựa chọn menu
    private void selectedNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.retaurant:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_RESTAURANT;
                        break;
                    case R.id.hotel:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_HOTEL;
                        break;
                    case R.id.mall:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_MARKET;
                        break;
                    case R.id.phone:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_SMARTPHONE;
                        break;
                    case R.id.clothes:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_CLOTHES;
                        break;
                    case R.id.cafe:
                        navItemIndex = 6;
                        CURRENT_TAG = TAG_COFFEE;
                        break;
                    case R.id.gasstation:
                        navItemIndex = 7;
                        CURRENT_TAG = TAG_GASSTATION;
                        break;
                    default:
                        navItemIndex = 0;
                }

                if (item.isChecked()){
                    item.setChecked(false);
                }else {
                    item.setChecked(true);
                }
                item.setChecked(true);
                loadHomeFragMent();
                return true;
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        android.support.v7.app.ActionBarDrawerToggle actionBarDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,
                drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            return;
        }

        if(shoudLoadHomeFragOnBackPress){
            if (navItemIndex != 0){
                navItemIndex = 0;
                CURRENT_TAG =TAG_HOME;
                loadHomeFragMent();
                return;
            }
        }
    }

    private void addEvents() {

    }


    private void addControls() {
        db = new SQLDatasource(MainActivity.this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        //Tìm kiếm
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

         /*if (id == R.id.search){
            return true;
        }
        return super.onOptionsItemSelected(item);*/
         return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fab) {
            goToAlternativeDirection();
        }
    }

    private void goToAlternativeDirection() {
        openActivity(AlternativeDirectionMapsActivity.class);
    }

    public void openActivity(Class<?> cs) {
        startActivity(new Intent(this, cs));
    }

}

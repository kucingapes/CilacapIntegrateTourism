package com.kucingapes.utsman.cilacaptourism;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.localizationactivity.LanguageSetting;
import com.akexorcist.localizationactivity.LocalizationActivity;
import com.celerysoft.imagepager.ImagePager;
import com.celerysoft.imagepager.adapter.SimpleImagePagerAdapter;
import com.celerysoft.imagepager.animation.ZoomOutPageTransformer;
import com.celerysoft.imagepager.view.indicator.TextIndicator;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kelin.translucentbar.library.TranslucentBarManager;

import java.util.ArrayList;

import static com.kucingapes.utsman.cilacaptourism.R.string.bentengtitle;

public class MainActivity extends LocalizationActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    //<editor-fold desc="DEKLARASI LATLNG + MARKER">
    private static final LatLng alun = new LatLng(-7.7272976, 109.0094168);
    private static final LatLng teluk = new LatLng(-7.7338402, 109.0217855);
    private static final LatLng benteng = new LatLng(-7.7492326, 109.0172697);
    private static final LatLng cilacap = new LatLng(-7.7047547, 109.0269157);
    private static final LatLng lapas = new LatLng(-7.727578, 108.9254589);
    private static final LatLng benling = new LatLng(-7.726257, 108.9043153);
    private static final LatLng benkar = new LatLng(-7.729924, 108.9609053);
    private static final LatLng kerkhoff = new LatLng(-7.746237, 109.0165303);
    private static final LatLng klenteng = new LatLng(-7.732799, 109.0092039);
    private static final LatLng kalimpat = new LatLng(-7.781003, 109.0368216);
    private static final LatLng pasir = new LatLng(-7.7603992, 109.0422966);
    private static final LatLng srandil = new LatLng(-7.6848323, 109.1914025);
    private static final LatLng selok = new LatLng(-7.6821093, 109.1784918);
    private static final LatLng sodong = new LatLng(-7.6905884, 109.1744658);
    private static final LatLng sudarman = new LatLng(-7.6003263, 109.2118984);
    private static final LatLng padang = new LatLng(-7.443167, 108.647093);
    private static final LatLng maria = new LatLng(-7.716416, 108.896741);
    private static final LatLng masigit = new LatLng(-7.7226849, 108.8884518);
    private static final LatLng ptpn = new LatLng(-7.3478913, 108.7976312);
    private static final LatLng watu = new LatLng(-7.6367747, 109.2298287);
    private static final LatLng masjid = new LatLng(-7.7271378, 109.0100525);
    private static final LatLng jambu = new LatLng(-7.416211, 108.7187802);
    private static final LatLng sinder = new LatLng(-7.4149202, 108.7234116);
    private static final LatLng sumolangu = new LatLng(-7.6821093, 109.1784918);
    private static final LatLng stakesugihan = new LatLng(-7.61833, 109.12167);
    private static final LatLng stakarang = new LatLng(-7.6662416, 109.0757612);
    private static final LatLng stakroya = new LatLng(-7.439192, 108.7894434);
    private static final LatLng stamaos = new LatLng(-7.619092, 109.1394733);
    private static final LatLng stagumilir = new LatLng(-7.6851217, 109.042539);
    private static final LatLng stajeruk = new LatLng(-7.6238938, 109.0194841);
    private static final LatLng stakawu = new LatLng(-7.590806, 108.919277);
    private static final LatLng stagandrung = new LatLng(-7.527691, 108.858765);
    private static final LatLng stasidareja = new LatLng(-7.4863447, 108.8075186);
    private static final LatLng stacipari = new LatLng(-7.440304, 108.7610842);
    private static final LatLng stacil = new LatLng(-7.7360465, 109.0070703);

    //camera move ke atas
    private static final LatLng benteng_des = new LatLng(-7.7543739, 109.0173674);
    private static final LatLng teluk_des = new LatLng(-7.7382952, 109.0215429);
    private static final LatLng benling_des = new LatLng(-7.7299036, 108.9044333);
    private static final LatLng benkar_des = new LatLng(-7.7327307, 108.9608731);
    private static final LatLng lapas_des = new LatLng(-7.730895, 108.9255018);
    private static final LatLng kerkhoff_des = new LatLng(-7.7495964, 109.0165518);
    private static final LatLng klenteng_des = new LatLng(-7.7367857, 109.009279);
    private static final LatLng kalimpat_des = new LatLng(-7.784277, 109.0369503);
    private static final LatLng pasir_des = new LatLng(-7.7638329, 109.0424897);
    private static final LatLng alun_des = new LatLng(-7.7304942, 109.0093948);
    private static final LatLng srandil_des = new LatLng(-7.6888301, 109.1913059);
    private static final LatLng selok_des = new LatLng(-7.6851927, 109.1785347);
    private static final LatLng sodong_des = new LatLng(-7.69381, 109.1745516);
    private static final LatLng sudarman_des = new LatLng(-7.6037719, 109.2119091);
    private static final LatLng padang_des = new LatLng(-7.4468372, 108.6471252);
    private static final LatLng maria_des = new LatLng(-7.7199351, 108.8968268);
    private static final LatLng masigit_des = new LatLng(-7.7267567, 108.8885591);
    private static final LatLng ptpn_des = new LatLng(-7.3513921, 108.7976527);

    private static final LatLng watu_des = new LatLng(-7.6419425, 109.2301934);
    private static final LatLng masjid_des = new LatLng(-7.7312096, 109.0102456);
    private static final LatLng jambu_des = new LatLng(-7.4197325, 108.7187371);
    private static final LatLng sinder_des = new LatLng(-7.4183397, 108.7234894);
    private static final LatLng sumolangu_des = new LatLng(-7.6851927, 109.1785347);

    private static final LatLng stakesugihan_des = new LatLng(-7.6221443, 109.1218427);
    private static final LatLng stakarang_des = new LatLng(-7.6701758, 109.0757719);
    private static final LatLng stakroya_des = new LatLng(-7.4421495, 108.7895936);
    private static final LatLng stamaos_des = new LatLng(-7.6232605, 109.1394733);
    private static final LatLng stagumilir_des = new LatLng(-7.6887686, 109.0426034);
    private static final LatLng stajeruk_des = new LatLng(-7.627722, 109.0194841);
    private static final LatLng stakawu_des = new LatLng(-7.5946036, 108.9192191);
    private static final LatLng stagandrung_des = new LatLng(-7.5315446, 108.8586273);
    private static final LatLng stasidareja_des = new LatLng(-7.4901488, 108.8073019);
    private static final LatLng stacipari_des = new LatLng(-7.4442204, 108.7610791);
    private static final LatLng stacil_des = new LatLng(-7.7402828, 109.0072556);

    private Marker malun;
    private Marker mteluk;
    private Marker mbenteng;
    private Marker mbenling;
    private Marker mlapas;
    private Marker mbenkar;
    private Marker mkerkhoff;
    private Marker mklenteng;
    private Marker mkalimpat;
    private Marker mpasir;
    private Marker msrandil;
    private Marker mselok;
    private Marker msodong;
    private Marker msudarman;
    private Marker mpadang;
    private Marker mmaria;
    private Marker mmasigit;
    private Marker mptpn;
    private Marker mwatu;
    private Marker mmasjid;
    private Marker mjambu;
    private Marker msinder;
    private Marker msumolangu;
    private Marker mstakesugihan;
    private Marker mstakarang;
    private Marker mstakroya;
    private Marker mstamaos;
    private Marker mstagumilir;
    private Marker mstajeruk;
    private Marker mstakawu;
    private Marker mstagandrung;
    private Marker mstasidareja;
    private Marker mstacipari;
    private Marker mstacil;
    //</editor-fold>

    private Button button_colapse;
    private Button button_expand;
    private RelativeLayout bottomsheet_layout;
    private RelativeLayout artikel;
    private TextView judul;
    private TextView alamat;
    private TextView desa;
    private TextView judulartikel;
    private TextView alamatartikel;
    private TextView desaartikel;
    private TextView isiartikel;
    private ImageView image_cover;
    //private TextView web;
    private FloatingActionButton arah;
    private FloatingActionButton galeri;
    private FloatingActionButton arahsheet;
    private AppBarLayout appbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private GoogleMap mMap;
    private Handler handler = new Handler();

    private Toolbar toolbar_artikel;

    private String currentLanguage = LanguageSetting.getDefaultLanguage();

    private ImagePager imagePager;
    private SimpleImagePagerAdapter mAdapter;

    private ListView listView;
    private ArrayList<String> stringArrayList;
    private ListViewAdapter adapter;

    public void relatifbg(View view) {
        return;
    }


    private class InfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        private final View myContentsView;

        InfoWindowAdapter(){
            myContentsView = getLayoutInflater().inflate(R.layout.info_window, null);
        }

        @Override
        public View getInfoContents(Marker marker) {

            TextView tvTitle = ((TextView)myContentsView.findViewById(R.id.title));
            tvTitle.setText(marker.getTitle());
            TextView tvSnippet = ((TextView)myContentsView.findViewById(R.id.snippet));
            tvSnippet.setText(marker.getSnippet());

            return myContentsView;
        }

        @Override
        public View getInfoWindow(Marker marker) {
            // TODO Auto-generated method stub
            return null;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //StatusBarUtil.setTransparent(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bindView();
        hide_awalan();

        TranslucentBarManager translucentBarManager = new TranslucentBarManager(this);
        //translucentBarManager.translucent(this);
        translucentBarManager.transparent(this);

        listView = (ListView) findViewById(R.id.list_item);
        listView.setVisibility(View.GONE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.openDrawer(Gravity.START);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        setData();
        adapter = new ListViewAdapter(this, R.layout.item_listview, stringArrayList);
        listView.setAdapter(adapter);
    }

    private void hide_awalan() {
        //bottomsheet_layout.setVisibility(View.GONE);
        //button_colapse.setVisibility(View.GONE);
        artikel.setVisibility(View.GONE);
    }

    private void bindView() {
//        button_colapse = (Button) findViewById(R.id.collapse);
        button_expand = (Button) findViewById(R.id.expand);
        bottomsheet_layout = (RelativeLayout) findViewById(R.id.bottomsheetlayout);
        artikel = (RelativeLayout) findViewById(R.id.artikel);
        judul = (TextView) findViewById(R.id.judulsheet);
        alamat = (TextView) findViewById(R.id.alamatsheet);
        desa = (TextView) findViewById(R.id.desasheet);
        judulartikel = (TextView) findViewById(R.id.judul);
        alamatartikel = (TextView) findViewById(R.id.alamat);
        desaartikel = (TextView) findViewById(R.id.desa);
        isiartikel = (TextView) findViewById(R.id.isiartikel);
        image_cover = (ImageView) findViewById(R.id.cover);
        arah = (FloatingActionButton) findViewById(R.id.arah);
        arahsheet = (FloatingActionButton) findViewById(R.id.arahsheet);
        galeri = (FloatingActionButton) findViewById(R.id.galeri);
        imagePager = (ImagePager) findViewById(R.id.main_image_pager);
        //about = (RelativeLayout) findViewById(R.id.about_page);
        toolbar_artikel = (Toolbar) findViewById(R.id.toolbar_artikel);
        appbar = (AppBarLayout) findViewById(R.id.app_bar_layout_artikel);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.colap);
    }

    @Override
    public void onBackPressed() {
        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down_bottom);
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up_bottom);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (bottomsheet_layout.getVisibility() == View.VISIBLE) {
            bottomsheet_layout.startAnimation(slideDown);
            bottomsheet_layout.setVisibility(View.GONE);
        } else if (artikel.getVisibility() == View.VISIBLE) {
            getSupportActionBar().show();
            artikel.startAnimation(slideDown);
            artikel.setVisibility(View.GONE);
            bottomsheet_layout.startAnimation(slideUp);
            bottomsheet_layout.setVisibility(View.VISIBLE);
        } else if (imagePager.getVisibility() == View.VISIBLE) {
            imagePager.setVisibility(View.GONE);
            artikel.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    private void setData() {
        stringArrayList = new ArrayList<>();
        stringArrayList.add(getString(bentengtitle));
        stringArrayList.add(getString(R.string.benlingtitle));
        stringArrayList.add(getString(R.string.benkartitle));
        stringArrayList.add(getString(R.string.lapastitle2));
        stringArrayList.add(getString(R.string.kerkhofftitle));
        stringArrayList.add(getString(R.string.klentengtitle));
        stringArrayList.add(getString(R.string.teluktitle));
        stringArrayList.add(getString(R.string.kalimpattitle));
        stringArrayList.add(getString(R.string.pasirtitle));
        stringArrayList.add(getString(R.string.aluntitle));
        stringArrayList.add(getString(R.string.srandiltitle));
        stringArrayList.add(getString(R.string.seloktitle));
        stringArrayList.add(getString(R.string.sodongtitle));
        stringArrayList.add(getString(R.string.sudarmantitle));
        stringArrayList.add(getString(R.string.padangtitle));
        stringArrayList.add(getString(R.string.mariatitle));
        stringArrayList.add(getString(R.string.masigittitle));
        stringArrayList.add(getString(R.string.ptpntitle));
        stringArrayList.add(getString(R.string.watutitle));
        stringArrayList.add(getString(R.string.masjidtitle));
        stringArrayList.add(getString(R.string.jambutitle));
        stringArrayList.add(getString(R.string.sindertitle));
        stringArrayList.add(getString(R.string.sumolangutitle));
        stringArrayList.add(getString(R.string.stakesugihantitle));
        stringArrayList.add(getString(R.string.stakarangtitle));
        stringArrayList.add(getString(R.string.stakroyatitle));
        stringArrayList.add(getString(R.string.stamaostitle));
        stringArrayList.add(getString(R.string.stagumilirtitle));
        stringArrayList.add(getString(R.string.stajeruktitle));
        stringArrayList.add(getString(R.string.stakawutitle));
        stringArrayList.add(getString(R.string.stagandrungtitle));
        stringArrayList.add(getString(R.string.stasidarejatitle));
        stringArrayList.add(getString(R.string.staciparititle));
        stringArrayList.add(getString(R.string.staciltitle));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public void onClick(View v) {

            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                listView.setVisibility(View.VISIBLE);
                if (TextUtils.isEmpty(newText)) {
                    adapter.filter("");
                    listView.setVisibility(View.GONE);
                    listView.clearTextFilter();
                } else
                //listView.setVisibility(View.GONE);

                {
                    adapter.filter(newText);
                }

                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals(getString(bentengtitle))) {
                    NavigationViewMethod();
                    navbenteng();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.benlingtitle))){
                    NavigationViewMethod();
                    navbenling();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.lapastitle))){
                    NavigationViewMethod();
                    navlapas();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.benkartitle))){
                    NavigationViewMethod();
                    navbenkar();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.klentengtitle))){
                    NavigationViewMethod();
                    navklenteng();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.teluktitle))){
                    NavigationViewMethod();
                    navteluk();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.kalimpattitle))){
                    NavigationViewMethod();
                    navkalimpat();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.pasirtitle))){
                    NavigationViewMethod();
                    navpasir();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.kerkhofftitle))){
                    NavigationViewMethod();
                    navkerkhoff();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.aluntitle))){
                    NavigationViewMethod();
                    navalun();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.ptpntitle))){
                    NavigationViewMethod();
                    navptpn();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.masjidtitle))){
                    NavigationViewMethod();
                    navmasjid();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.srandiltitle))){
                    NavigationViewMethod();
                    navsrandil();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.seloktitle))){
                    NavigationViewMethod();
                    navselok();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.sodongtitle))){
                    NavigationViewMethod();
                    navsodong();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.sumolangutitle))){
                    NavigationViewMethod();
                    navsumolangu();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.sudarmantitle))){
                    NavigationViewMethod();
                    navsudarman();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.padangtitle))){
                    NavigationViewMethod();
                    navpadang();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.mariatitle))){
                    NavigationViewMethod();
                    navmaria();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.masigittitle))){
                    NavigationViewMethod();
                    navmasigit();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.watutitle))){
                    NavigationViewMethod();
                    navwatu();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.jambutitle))){
                    NavigationViewMethod();
                    navjambu();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.sindertitle))){
                    NavigationViewMethod();
                    navsinder();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.staciltitle))){
                    NavigationViewMethod();
                    navstacil();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.stakesugihantitle))){
                    NavigationViewMethod();
                    navstakesugihan();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.stamaostitle))){
                    NavigationViewMethod();
                    navstamaos();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.stakarangtitle))){
                    NavigationViewMethod();
                    navstakarang();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.stakroyatitle))){
                    NavigationViewMethod();
                    navstakroya();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.stagumilirtitle))){
                    NavigationViewMethod();
                    navstagumilir();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.stajeruktitle))){
                    NavigationViewMethod();
                    navstajeruk();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.stakawutitle))){
                    NavigationViewMethod();
                    navstakawu();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.stagandrungtitle))){
                    NavigationViewMethod();
                    navstagandrung();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.stasidarejatitle))){
                    NavigationViewMethod();
                    navstasidareja();
                } else if (parent.getItemAtPosition(position).equals(getString(R.string.staciparititle))){
                    NavigationViewMethod();
                    navstacipari();
                }

                listView.setVisibility(View.GONE);
                searchView.onActionViewCollapsed();
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.setting) {
            menuSetting();
        } else if (id == R.id.nav_selatan) {
            delayDrawerSelatan();

        } else if (id == R.id.nav_about){
            Intent i = new Intent(this, About.class);
            startActivity(i);
        }

        else if (id == R.id.nav_adipala) {
            delayDrawerAdipala();

        } else if (id == R.id.nav_about_cilacap) {
            String url = "https://id.wikipedia.org/wiki/Kabupaten_Cilacap";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        } else if (id == R.id.nav_kroya) {
            delayDrawerKroya();

        } else if (id == R.id.nav_majenang) {
            delayDrawerMajenang();

        } else if (id == R.id.nav_kampunglaut) {
            delayDrawerKampunglaut();

        } else if (id == R.id.nav_kesugihan) {
            delayDrawerKesugihan();

        } else if (id == R.id.nav_wanareja) {
            delayDrawerWanareja();

        } else if (id == R.id.nav_stasiun) {
            delayDrawerStasiun();

        } else if (id == R.id.nav_back) {
            delayDrawerBack();

        } else if (id == R.id.nav_tengah) {
            delayDrawerTengah();
        }
        //</editor-fold>

        //<editor-fold desc="OBJEKNYA">
        //Cilacap Selatan
        else if (id == R.id.nav_benteng) {
            NavigationViewMethod();
            navbenteng();
            //bottomSheetCollapse();
            //fabarahBenteng();

        } else if (id == R.id.nav_benling) {
            NavigationViewMethod();
            navbenling();
            //bottomSheetCollapse();
            //fabarahBenling();

        } else if (id == R.id.nav_lapas) {
            NavigationViewMethod();
            navlapas();
            //bottomSheetCollapse();
            //fabarahLapas();

        } else if (id == R.id.nav_benkar) {
            NavigationViewMethod();
            navbenkar();
            //bottomSheetCollapse();
            //fabarahbenkar();


        } else if (id == R.id.nav_klenteng) {
            NavigationViewMethod();
            navklenteng();

        } else if (id == R.id.nav_teluk) {
            NavigationViewMethod();
            navteluk();

        } else if (id == R.id.nav_kalimpat) {
            NavigationViewMethod();
            navkalimpat();

        } else if (id == R.id.nav_pasir) {
            NavigationViewMethod();
            navpasir();

        } else if (id == R.id.nav_kerkhoff) {
            NavigationViewMethod();
            navkerkhoff();
        }

        //Cilacap Tengah
        else if (id == R.id.nav_alun) {
            NavigationViewMethod();
            navalun();

        } else if (id == R.id.nav_ptpn) {
            NavigationViewMethod();
            navptpn();

        } else if (id == R.id.nav_masjid) {
            NavigationViewMethod();
            navmasjid();
        }

        //Adilapa
        else if (id == R.id.nav_srandil) {
            NavigationViewMethod();
            navsrandil();

        } else if (id == R.id.nav_selok) {
            NavigationViewMethod();
            navselok();

        } else if (id == R.id.nav_sodong) {
            NavigationViewMethod();
            navsodong();

        } else if (id == R.id.nav_sumolangu) {
            NavigationViewMethod();
            navsumolangu();
        }

        //Kroya
        else if (id == R.id.nav_sudarman) {
            NavigationViewMethod();
            navsudarman();
        }

        //Majenang
        else if (id == R.id.nav_padang) {
            NavigationViewMethod();
            navpadang();
        }

        //Kampunglaut
        else if (id == R.id.nav_maria) {
            NavigationViewMethod();
            navmaria();

        } else if (id == R.id.nav_masigit) {
            NavigationViewMethod();
            navmasigit();
        }
        //Kesughian
        else if (id == R.id.nav_watu) {
            NavigationViewMethod();
            navwatu();
        }
        //Wanareja
        else if (id == R.id.nav_jambu) {
            NavigationViewMethod();
            navjambu();
        } else if (id == R.id.nav_sinder) {
            NavigationViewMethod();
            navsinder();
        }

        //Stasiun
        else if (id == R.id.nav_stacil) {
            NavigationViewMethod();
            navstacil();
        } else if (id == R.id.nav_stakesugihan) {
            NavigationViewMethod();
            navstakesugihan();
        } else if (id == R.id.nav_stakarang) {
            NavigationViewMethod();
            navstakarang();
        } else if (id == R.id.nav_stakroya) {
            NavigationViewMethod();
            navstakroya();
        } else if (id == R.id.nav_stamaos) {
            NavigationViewMethod();
            navstamaos();
        } else if (id == R.id.nav_stagumilir) {
            NavigationViewMethod();
            navstagumilir();
        } else if (id == R.id.nav_stajeruk) {
            NavigationViewMethod();
            navstajeruk();
        } else if (id == R.id.nav_stakawu) {
            NavigationViewMethod();
            navstakawu();
        } else if (id == R.id.nav_stagandrung) {
            NavigationViewMethod();
            navstagandrung();
        } else if (id == R.id.nav_stasidareja) {
            NavigationViewMethod();
            navstasidareja();
        } else if (id == R.id.nav_stacipari) {
            NavigationViewMethod();
            navstacipari();
        }


        //</editor-fold>

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //<editor-fold desc="DELAY">

    private void delayDrawerTengah() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CilacapTengah();
            }
        }, 400);
    }

    private void delayDrawerSelatan() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CilacapSelatan();
            }
        }, 400);
    }


    private void delayDrawerAdipala() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CilacapAdipala();
            }
        }, 400);
    }

    private void delayDrawerKroya() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CilacapKroya();
            }
        }, 400);
    }

    private void delayDrawerMajenang() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CilacapMajenang();
            }
        }, 400);
    }

    private void delayDrawerKampunglaut() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CilacapKampunglaut();
            }
        }, 400);
    }

    private void delayDrawerKesugihan() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CilacapKesugihan();
            }
        }, 400);
    }

    private void delayDrawerWanareja() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CilacapWanareja();
            }
        }, 400);
    }

    private void delayDrawerStasiun() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CilacapStasiun();
            }
        }, 400);
    }

    //</editor-fold>

    public void artikel_expand(View view) {
        Animation bottomUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up_bottom);
        artikel.startAnimation(bottomUp);
        artikel.setVisibility(View.VISIBLE);
        //getSupportActionBar().hide();
        bottomsheet_layout.setVisibility(View.GONE);
    }

    public void kembali(View view) {
        Animation bottomDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down_bottom);
        Animation bottomUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up_bottom);
        artikel.startAnimation(bottomDown);
        artikel.setVisibility(View.GONE);
        bottomsheet_layout.startAnimation(bottomUp);
        getSupportActionBar().show();
        bottomsheet_layout.setVisibility(View.VISIBLE);
        appbar.setExpanded(true, true);
    }

    public void noimage() {
        Toast.makeText(getBaseContext(), getString(R.string.noimg),
                Toast.LENGTH_SHORT).show();
    }

    private void DrawerKiri() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.openDrawer(Gravity.START);
        Animation bottomDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down_bottom);
        if (bottomsheet_layout.getVisibility() == View.VISIBLE) {
            bottomsheet_layout.startAnimation(bottomDown);
            bottomsheet_layout.setVisibility(View.GONE);
        } else if (bottomsheet_layout.getVisibility() == View.GONE) {
            bottomsheet_layout.setVisibility(View.GONE);
        }
    }

    //<editor-fold desc="METHOD KECAMATAN MENU DRAWER">
    private void CilacapTengah() {
        DrawerKiri();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.tengah_menu);
    }

    private void CilacapSelatan() {
        DrawerKiri();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.selatan_menu);
    }

    private void CilacapAdipala() {
        DrawerKiri();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.adipala_menu);
    }

    private void CilacapKroya() {
        DrawerKiri();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.kroya_menu);
    }

    private void CilacapMajenang() {
        DrawerKiri();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.majenang_menu);
    }

    private void CilacapKampunglaut() {
        DrawerKiri();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.kampung_laut_menu);
    }

    private void CilacapKesugihan() {
        DrawerKiri();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.kesugihan_menu);
    }

    private void CilacapWanareja() {
        DrawerKiri();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.wanareja_menu);
    }

    private void CilacapStasiun() {
        DrawerKiri();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.stasiun_menu);
    }


    //</editor-fold>

    //<editor-fold desc="DRAWER BACK + DELAY">
    private void delayDrawerBack() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(Gravity.START);
                NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
                navigationView.setNavigationItemSelectedListener(MainActivity.this);
                navigationView.getMenu().clear();
                navigationView.inflateMenu(R.menu.activity_main_drawer);
            }
        }, 400);
    }

    //</editor-fold>

    private void NavigationViewMethod() {
        Animation bottomUp = AnimationUtils.loadAnimation(this, R.anim.slide_up_bottom);
        bottomsheet_layout.startAnimation(bottomUp);
        bottomsheet_layout.setVisibility(View.VISIBLE);
    }

    private void menuSetting() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getString(R.string.bahasa));
        alertDialog.setMessage(getString(R.string.lang));

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "English",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        setLanguage("en");
                        dialog.dismiss();
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Indonesia",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        setLanguage("in");
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

        Button btnPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button btnNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) btnPositive.getLayoutParams();
        layoutParams.weight = 10;
        btnPositive.setLayoutParams(layoutParams);
        btnNegative.setLayoutParams(layoutParams);
    }

    public void onMapReady(GoogleMap map) {
        MapStyleOptions style = MapStyleOptions.loadRawResourceStyle(this, R.raw.style_classic);
        map.setMapStyle(style);
        mMap = map;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cilacap, 10));
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.setInfoWindowAdapter(new InfoWindowAdapter());
        //mMap.setInfoWindowAdapter(new MyInfoWindowAdapter());
        //final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //<editor-fold desc="MARKER">
        malun = mMap.addMarker(new MarkerOptions()
                .position(alun)
                .title(getString(R.string.aluntitle))
                .snippet(getString(R.string.alunalt))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mteluk = mMap.addMarker(new MarkerOptions()
                .position(teluk)
                .title(getString(R.string.teluktitle))
                .snippet(getString(R.string.telukalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mbenteng = mMap.addMarker(new MarkerOptions()
                .position(benteng)
                .title(getString(bentengtitle))
                .snippet(getString(R.string.bentengalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ben)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mbenling = mMap.addMarker(new MarkerOptions()
                .position(benling)
                .title(getString(R.string.benlingtitle))
                .snippet(getString(R.string.benlingalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ben)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mlapas = mMap.addMarker(new MarkerOptions()
                .position(lapas)
                .title(getString(R.string.lapastitle2))
                .snippet(getString(R.string.lapasalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_lapas)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mbenkar = mMap.addMarker(new MarkerOptions()
                .position(benkar)
                .title(getString(R.string.benkartitle))
                .snippet(getString(R.string.benkaralt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ben)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mkerkhoff = mMap.addMarker(new MarkerOptions()
                .position(kerkhoff)
                .title(getString(R.string.kerkhofftitle))
                .snippet(getString(R.string.kerkhoffalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_makam)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mklenteng = mMap.addMarker(new MarkerOptions()
                .position(klenteng)
                .title(getString(R.string.klentengtitle2))
                .snippet(getString(R.string.klentengalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_castle)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        mkalimpat = mMap.addMarker(new MarkerOptions()
                .position(kalimpat)
                .title(getString(R.string.kalimpattitle))
                .snippet(getString(R.string.kalimpatalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_pantai_red)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mpasir = mMap.addMarker(new MarkerOptions()
                .position(pasir)
                .title(getString(R.string.pasirtitle))
                .snippet(getString(R.string.pasiralt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_pantai_red)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        msrandil = mMap.addMarker(new MarkerOptions()
                .position(srandil)
                .title(getString(R.string.srandiltitle))
                .snippet(getString(R.string.srandilalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_gunung)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mselok = mMap.addMarker(new MarkerOptions()
                .position(selok)
                .title(getString(R.string.seloktitle))
                .snippet(getString(R.string.selokalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_gunung)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        msodong = mMap.addMarker(new MarkerOptions()
                .position(sodong)
                .title(getString(R.string.sodongtitle))
                .snippet(getString(R.string.sodongalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_pantai_yellow)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        msudarman = mMap.addMarker(new MarkerOptions()
                .position(sudarman)
                .title(getString(R.string.sudarmantitle))
                .snippet(getString(R.string.sudarmanalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_museum)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mpadang = mMap.addMarker(new MarkerOptions()
                .position(padang)
                .title(getString(R.string.padangtitle))
                .snippet(getString(R.string.padangalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_gunung_majenang)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mmaria = mMap.addMarker(new MarkerOptions()
                .position(maria)
                .title(getString(R.string.mariatitle))
                .snippet(getString(R.string.mariaalt))
                // .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_cave_kampung)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mmasigit = mMap.addMarker(new MarkerOptions()
                .position(masigit)
                .title(getString(R.string.masigittitle))
                .snippet(getString(R.string.masigitalt))
                // .icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_cave_kampung)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mptpn = mMap.addMarker(new MarkerOptions()
                .position(ptpn)
                .title(getString(R.string.ptpntitle))
                .snippet(getString(R.string.ptpnalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mwatu = mMap.addMarker(new MarkerOptions()
                .position(watu)
                .title(getString(R.string.watutitle))
                .snippet(getString(R.string.watualt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));


        mmasjid = mMap.addMarker(new MarkerOptions()
                .position(masjid)
                .title(getString(R.string.masjidtitle))
                .snippet(getString(R.string.masjidalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mjambu = mMap.addMarker(new MarkerOptions()
                .position(jambu)
                .title(getString(R.string.jambutitle))
                .snippet(getString(R.string.jambualt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        msinder = mMap.addMarker(new MarkerOptions()
                .position(sinder)
                .title(getString(R.string.sindertitle))
                .snippet(getString(R.string.sinderalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        msumolangu = mMap.addMarker(new MarkerOptions()
                .position(sumolangu)
                .title(getString(R.string.sumolangutitle))
                .snippet(getString(R.string.sumolangualt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstakesugihan = mMap.addMarker(new MarkerOptions()
                .position(stakesugihan)
                .title(getString(R.string.stakesugihantitle))
                .snippet(getString(R.string.stakesugihanalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstakarang = mMap.addMarker(new MarkerOptions()
                .position(stakarang)
                .title(getString(R.string.stakarangtitle))
                .snippet(getString(R.string.stakarangalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstakroya = mMap.addMarker(new MarkerOptions()
                .position(stakroya)
                .title(getString(R.string.stakroyatitle))
                .snippet(getString(R.string.stakroyaalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstamaos = mMap.addMarker(new MarkerOptions()
                .position(stamaos)
                .title(getString(R.string.stamaostitle))
                .snippet(getString(R.string.stamaosalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstagumilir = mMap.addMarker(new MarkerOptions()
                .position(stagumilir)
                .title(getString(R.string.stagumilirtitle))
                .snippet(getString(R.string.stagumiliralt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstajeruk = mMap.addMarker(new MarkerOptions()
                .position(stajeruk)
                .title(getString(R.string.stajeruktitle))
                .snippet(getString(R.string.stajerukalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstakawu = mMap.addMarker(new MarkerOptions()
                .position(stakawu)
                .title(getString(R.string.stakawutitle))
                .snippet(getString(R.string.stakawualt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstagandrung = mMap.addMarker(new MarkerOptions()
                .position(stagandrung)
                .title(getString(R.string.stagandrungtitle))
                .snippet(getString(R.string.stagandrungalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstasidareja = mMap.addMarker(new MarkerOptions()
                .position(stasidareja)
                .title(getString(R.string.stasidarejatitle))
                .snippet(getString(R.string.stasidarejaalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstacipari = mMap.addMarker(new MarkerOptions()
                .position(stacipari)
                .title(getString(R.string.staciparititle))
                .snippet(getString(R.string.staciparialt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));

        mstacil = mMap.addMarker(new MarkerOptions()
                .position(stacil)
                .title(getString(R.string.staciltitle))
                .snippet(getString(R.string.stacilalt))
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.mar_ptpn)));
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        //</editor-fold>

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                Animation bottomDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down_bottom);
                if (bottomsheet_layout.getVisibility() == View.VISIBLE) {
                    bottomsheet_layout.startAnimation(bottomDown);
                    bottomsheet_layout.setVisibility(View.GONE);
                }
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker.equals(mbenteng)){
                    NavigationViewMethod();
                    navbenteng();
                } else if (marker.equals(mbenling)){
                    NavigationViewMethod();
                    navbenling();
                } else if (marker.equals(mlapas)){
                    NavigationViewMethod();
                    navlapas();
                } else if (marker.equals(mbenkar)){
                    NavigationViewMethod();
                    navbenkar();
                } else if (marker.equals(mklenteng)){
                    NavigationViewMethod();
                    navklenteng();
                } else if (marker.equals(mteluk)){
                    NavigationViewMethod();
                    navteluk();
                } else if (marker.equals(mkalimpat)){
                    NavigationViewMethod();
                    navkalimpat();
                } else if (marker.equals(mpasir)){
                    NavigationViewMethod();
                    navpasir();
                } else if (marker.equals(mkerkhoff)){
                    NavigationViewMethod();
                    navkerkhoff();
                } else if (marker.equals(malun)){
                    NavigationViewMethod();
                    navalun();
                } else if (marker.equals(mptpn)){
                    NavigationViewMethod();
                    navptpn();
                } else if (marker.equals(mmasjid)){
                    NavigationViewMethod();
                    navmasjid();
                } else if (marker.equals(msrandil)){
                    NavigationViewMethod();
                    navsrandil();
                } else if (marker.equals(mselok)){
                    NavigationViewMethod();
                    navselok();
                } else if (marker.equals(msodong)){
                    NavigationViewMethod();
                    navsodong();
                } else if (marker.equals(msumolangu)){
                    NavigationViewMethod();
                    navsumolangu();
                } else if (marker.equals(msudarman)){
                    NavigationViewMethod();
                    navsudarman();
                } else if (marker.equals(mpadang)){
                    NavigationViewMethod();
                    navpadang();
                } else if (marker.equals(mmaria)){
                    NavigationViewMethod();
                    navmaria();
                } else if (marker.equals(mmasigit)){
                    NavigationViewMethod();
                    navmasigit();
                } else if (marker.equals(mwatu)){
                    NavigationViewMethod();
                    navwatu();
                } else if (marker.equals(mjambu)){
                    NavigationViewMethod();
                    navjambu();
                } else if (marker.equals(msinder)){
                    NavigationViewMethod();
                    navsinder();
                } else if (marker.equals(mstacil)) {
                    NavigationViewMethod();
                    navstacil();
                } else if (marker.equals(mstakesugihan)){
                    NavigationViewMethod();
                    navstakesugihan();
                } else if (marker.equals(mstakarang)){
                    NavigationViewMethod();
                    navstakarang();
                } else if (marker.equals(mstakroya)){
                    NavigationViewMethod();
                    navstakroya();
                } else if (marker.equals(mstamaos)){
                    NavigationViewMethod();
                    navstamaos();
                } else if (marker.equals(mstagumilir)){
                    NavigationViewMethod();
                    navstagumilir();
                } else if (marker.equals(mstajeruk)){
                    NavigationViewMethod();
                    navstajeruk();
                } else if (marker.equals(mstakawu)){
                    NavigationViewMethod();
                    navstakawu();
                } else if (marker.equals(mstagandrung)){
                    NavigationViewMethod();
                    navstagandrung();
                } else if (marker.equals(mstasidareja)){
                    NavigationViewMethod();
                    navstasidareja();
                } else if (marker.equals(mstacipari)){
                    NavigationViewMethod();
                    navstacipari();
                }

                return false;
            }
        });

    }



    //<editor-fold desc="METHOD-OBJEK">
    private void navbenteng() {


        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(benteng)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mbenteng.showInfoWindow();
        image_cover.setImageResource(R.drawable.benteng1);
        judul.setText(getString(bentengtitle));
        alamat.setText(getString(R.string.bentengalt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(bentengtitle));
        alamatartikel.setText(getString(R.string.bentengalt));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.bentengdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7492326 + ","
                                + 109.0172697));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7492326 + ","
                                + 109.0172697));
                startActivity(i);
            }
        });
        //galeri.setVisibility(View.VISIBLE);
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerybenteng();
            }
        });

        //toolbar_artikel.setTitle(getString(R.string.bentengtitle));
        //this.setTitle(getString(R.string.bentengtitle));
        //toolbar_artikel.setTitleTextColor(android.graphics.Color.WHITE);

        collapsingToolbarLayout.setTitle(getString(R.string.bentengtitle));

    }

    private void navbenling() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(benling)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mbenling.showInfoWindow();
        image_cover.setImageResource(R.drawable.benling1);
        judul.setText(getString(R.string.benlingtitle));
        alamat.setText(getString(R.string.benlingalt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(R.string.benlingtitle));
        alamatartikel.setText(getString(R.string.benlingalt));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.benlingdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.726257 + ","
                                + 108.9043153));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.726257 + ","
                                + 108.9043153));
                startActivity(i);
            }
        });
        //galeri.setVisibility(View.VISIBLE);
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerybenling();
            }
        });
        //collapsingToolbarLayout.setTitleEnabled(false);
        collapsingToolbarLayout.setTitle(getString(R.string.benlingtitle));

    }

    private void navlapas() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(lapas)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mlapas.showInfoWindow();
        image_cover.setImageResource(R.drawable.lapas1);
        judul.setText(getString(R.string.lapastitle2));
        alamat.setText(getString(R.string.lapasalt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(R.string.lapastitle2));
        alamatartikel.setText(getString(R.string.lapasalt));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.lapasdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.730895 + ","
                                + 108.9255018));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.730895 + ","
                                + 108.9255018));
                startActivity(i);
            }
        });
        //galeri.setVisibility(View.VISIBLE);
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerylapas();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.lapastitle2));

    }

    private void navbenkar() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(benkar)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mbenkar.showInfoWindow();
        image_cover.setImageResource(R.drawable.benkar1);
        judul.setText(getString(R.string.benkartitle));
        alamat.setText(getString(R.string.benkaralt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(R.string.benkartitle));
        alamatartikel.setText(getString(R.string.benkaralt));
        toolbar_artikel.setTitle(getString(R.string.benkartitle));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.benkardes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.730895 + ","
                                + 108.9255018));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.730895 + ","
                                + 108.9255018));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerybenkar();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.benkartitle));

    }

    private void navklenteng() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(klenteng)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mklenteng.showInfoWindow();
        image_cover.setImageResource(R.drawable.klenteng1);
        judul.setText(getString(R.string.klentengtitle));
        alamat.setText(getString(R.string.klentengalt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(R.string.klentengtitle));
        alamatartikel.setText(getString(R.string.klentengalt));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.klentengdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.732799 + ","
                                + 109.0092039));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.732799 + ","
                                + 109.0092039));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                galleryklenteng();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.klentengtitle));

    }

    private void navteluk() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(teluk)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mteluk.showInfoWindow();
        image_cover.setImageResource(R.drawable.teluk1);
        judul.setText(getString(R.string.teluktitle));
        alamat.setText(getString(R.string.telukalt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(R.string.teluktitle));
        alamatartikel.setText(getString(R.string.telukalt));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.telukdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7338402 + ","
                                + 109.0217855));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7338402 + ","
                                + 109.0217855));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noimage();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.teluktitle));
    }

    private void navkalimpat() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(kalimpat)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mkalimpat.showInfoWindow();
        image_cover.setImageResource(R.drawable.kalimpat1);
        judul.setText(getString(R.string.kalimpattitle));
        alamat.setText(getString(R.string.kalimpatalt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(R.string.kalimpattitle));
        alamatartikel.setText(getString(R.string.kalimpatalt));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.kalimpatdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.781003 + ","
                                + 109.0368216));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.781003 + ","
                                + 109.0368216));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noimage();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.kalimpattitle));
    }

    private void navpasir() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(pasir)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mpasir.showInfoWindow();
        image_cover.setImageResource(R.drawable.pasir1);
        judul.setText(getString(R.string.pasirtitle));
        alamat.setText(getString(R.string.pasiralt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(R.string.pasirtitle));
        alamatartikel.setText(getString(R.string.pasiralt));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.pasirdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7603992 + ","
                                + 109.0422966));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7603992 + ","
                                + 109.0422966));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerypasir();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.pasirtitle));

    }

    private void navalun() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(alun)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        malun.showInfoWindow();
        image_cover.setImageResource(R.drawable.alun1);
        judul.setText(getString(R.string.aluntitle));
        alamat.setText(getString(R.string.alunalt));
        desa.setText(getText(R.string.cilacap_tengah));
        judulartikel.setText(getString(R.string.aluntitle));
        alamatartikel.setText(getString(R.string.alunalt));
        desaartikel.setText(getString(R.string.cilacap_tengah));
        isiartikel.setText(Html.fromHtml(getString(R.string.alundes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7272976 + ","
                                + 109.0094168));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7272976 + ","
                                + 109.0094168));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                galleryalun();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.aluntitle));

    }

    private void navkerkhoff() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(kerkhoff)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mkerkhoff.showInfoWindow();
        image_cover.setImageResource(R.drawable.kerkhoff1);
        judul.setText(getString(R.string.kerkhofftitle));
        alamat.setText(getString(R.string.kerkhoffalt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(R.string.kerkhofftitle));
        alamatartikel.setText(getString(R.string.kerkhoffalt));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.kerkhoffdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7495964 + ","
                                + 109.0165518));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7495964 + ","
                                + 109.0165518));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerykerkhoff();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.kerkhofftitle));

    }

    private void navptpn() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(ptpn)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mptpn.showInfoWindow();
        image_cover.setImageResource(R.drawable.ptpn1);
        judul.setText(getString(R.string.ptpntitle));
        alamat.setText(getString(R.string.ptpnalt));
        desa.setText(getText(R.string.cilacap_tengah));
        judulartikel.setText(getString(R.string.ptpntitle));
        alamatartikel.setText(getString(R.string.ptpnalt));
        desaartikel.setText(getString(R.string.cilacap_tengah));
        isiartikel.setText(Html.fromHtml(getString(R.string.ptpndes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.3478913 + ","
                                + 108.7976312));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.3478913 + ","
                                + 108.7976312));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                galleryptpn();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.ptpntitle));

    }

    private void navmasjid() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(masjid)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mmasjid.showInfoWindow();
        image_cover.setImageResource(R.drawable.masjid1);
        judul.setText(getString(R.string.masjidtitle));
        alamat.setText(getString(R.string.masjidalt));
        desa.setText(getText(R.string.cilacap_tengah));
        judulartikel.setText(getString(R.string.masjidtitle));
        alamatartikel.setText(getString(R.string.masjidalt));
        desaartikel.setText(getString(R.string.cilacap_tengah));
        isiartikel.setText(Html.fromHtml(getString(R.string.masjiddes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7271378 + ","
                                + 109.0100525));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7271378 + ","
                                + 109.0100525));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerymasjid();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.masjidtitle));

    }

    private void navsrandil() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(srandil)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        msrandil.showInfoWindow();
        image_cover.setImageResource(R.drawable.srandil1);
        judul.setText(getString(R.string.srandiltitle));
        alamat.setText(getString(R.string.srandilalt));
        desa.setText(getText(R.string.adipala));
        judulartikel.setText(getString(R.string.srandiltitle));
        alamatartikel.setText(getString(R.string.srandilalt));
        desaartikel.setText(getString(R.string.adipala));
        isiartikel.setText(Html.fromHtml(getString(R.string.srandildes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6848323 + ","
                                + 109.1914025));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6848323 + ","
                                + 109.1914025));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerysrandil();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.srandiltitle));

    }

    private void navselok() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(selok)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mselok.showInfoWindow();
        image_cover.setImageResource(R.drawable.selok1);
        judul.setText(getString(R.string.seloktitle));
        alamat.setText(getString(R.string.selokalt));
        desa.setText(getText(R.string.adipala));
        judulartikel.setText(getString(R.string.seloktitle));
        alamatartikel.setText(getString(R.string.selokalt));
        desaartikel.setText(getString(R.string.adipala));
        isiartikel.setText(Html.fromHtml(getString(R.string.selokdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6821093 + ","
                                + 109.1784918));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6821093 + ","
                                + 109.1784918));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                galleryselok();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.seloktitle));

    }

    private void navsodong() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(sodong)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        msodong.showInfoWindow();
        image_cover.setImageResource(R.drawable.sodong1);
        judul.setText(getString(R.string.sodongtitle));
        alamat.setText(getString(R.string.sodongalt));
        desa.setText(getText(R.string.adipala));
        judulartikel.setText(getString(R.string.sodongtitle));
        alamatartikel.setText(getString(R.string.sodongalt));
        desaartikel.setText(getString(R.string.adipala));
        isiartikel.setText(Html.fromHtml(getString(R.string.sodongdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6905884 + ","
                                + 109.1744658));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6905884 + ","
                                + 109.1744658));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerysodong();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.sodongtitle));

    }

    private void navsumolangu() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(sumolangu)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        msumolangu.showInfoWindow();
        image_cover.setImageResource(R.drawable.noimg_tumb);
        judul.setText(getString(R.string.sumolangutitle));
        alamat.setText(getString(R.string.sumolangualt));
        desa.setText(getText(R.string.adipala));
        judulartikel.setText(getString(R.string.sumolangutitle));
        alamatartikel.setText(getString(R.string.sumolangualt));
        desaartikel.setText(getString(R.string.adipala));
        isiartikel.setText(Html.fromHtml(getString(R.string.sumolangudes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6905884 + ","
                                + 109.1744658));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6821093 + ","
                                + 109.1784918));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noimage();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.sumolangutitle));

    }

    private void navsudarman() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(sudarman)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        msudarman.showInfoWindow();
        image_cover.setImageResource(R.drawable.sudarman1);
        judul.setText(getString(R.string.sudarmantitle));
        alamat.setText(getString(R.string.sudarmanalt));
        desa.setText(getText(R.string.kroya));
        judulartikel.setText(getString(R.string.sudarmantitle));
        alamatartikel.setText(getString(R.string.sudarmanalt));
        desaartikel.setText(getString(R.string.kroya));
        isiartikel.setText(Html.fromHtml(getString(R.string.sudarmandes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6003263 + ","
                                + 109.2118984));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6003263 + ","
                                + 109.2118984));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerysudarman();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.sudarmantitle));

    }

    private void navpadang() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(padang)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mpadang.showInfoWindow();
        image_cover.setImageResource(R.drawable.padang1);
        judul.setText(getString(R.string.padangtitle));
        alamat.setText(getString(R.string.padangalt));
        desa.setText(getText(R.string.majenang));
        judulartikel.setText(getString(R.string.padangtitle));
        alamatartikel.setText(getString(R.string.padangalt));
        desaartikel.setText(getString(R.string.majenang));
        isiartikel.setText(Html.fromHtml(getString(R.string.padangdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.443167 + ","
                                + 108.647093));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.443167 + ","
                                + 108.647093));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerypadang();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.padangtitle));

    }

    private void navmaria() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(maria)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mmaria.showInfoWindow();
        image_cover.setImageResource(R.drawable.maria1);
        judul.setText(getString(R.string.mariatitle));
        alamat.setText(getString(R.string.mariaalt));
        desa.setText(getText(R.string.kampunglaut));
        judulartikel.setText(getString(R.string.mariatitle));
        alamatartikel.setText(getString(R.string.mariaalt));
        desaartikel.setText(getString(R.string.kampunglaut));
        isiartikel.setText(Html.fromHtml(getString(R.string.mariades)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7199351 + ","
                                + 108.8968268));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7199351 + ","
                                + 108.8968268));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerymaria();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.mariatitle));

    }

    private void navmasigit() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(masigit)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mmasigit.showInfoWindow();
        image_cover.setImageResource(R.drawable.masigit1);
        judul.setText(getString(R.string.masigittitle));
        alamat.setText(getString(R.string.masigitalt));
        desa.setText(getText(R.string.kampunglaut));
        judulartikel.setText(getString(R.string.masigittitle));
        alamatartikel.setText(getString(R.string.masigitalt));
        desaartikel.setText(getString(R.string.kampunglaut));
        isiartikel.setText(Html.fromHtml(getString(R.string.masigitdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7267567 + ","
                                + 108.8885591));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7267567 + ","
                                + 108.8885591));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerymasigit();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.masigittitle));

    }

    private void navwatu() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(watu)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mwatu.showInfoWindow();
        image_cover.setImageResource(R.drawable.noimg_tumb);
        judul.setText(getString(R.string.watutitle));
        alamat.setText(getString(R.string.watualt));
        desa.setText(getText(R.string.kesugihan));
        judulartikel.setText(getString(R.string.watutitle));
        alamatartikel.setText(getString(R.string.watualt));
        desaartikel.setText(getString(R.string.kesugihan));
        isiartikel.setText(Html.fromHtml(getString(R.string.watudes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.3513921 + ","
                                + 108.7976527));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.3513921 + ","
                                + 108.7976527));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noimage();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.watutitle));

    }

    private void navjambu() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(jambu)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mjambu.showInfoWindow();
        image_cover.setImageResource(R.drawable.jambu1);
        judul.setText(getString(R.string.jambutitle));
        alamat.setText(getString(R.string.jambualt));
        desa.setText(getText(R.string.wanareja));
        judulartikel.setText(getString(R.string.jambutitle));
        alamatartikel.setText(getString(R.string.jambualt));
        desaartikel.setText(getString(R.string.wanareja));
        isiartikel.setText(Html.fromHtml(getString(R.string.jambudes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.416211 + ","
                                + 108.7187802));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.416211 + ","
                                + 108.7187802));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                galleryjambu();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.jambutitle));

    }

    private void navsinder() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(sinder)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        msinder.showInfoWindow();
        image_cover.setImageResource(R.drawable.noimg_tumb);
        judul.setText(getString(R.string.sindertitle));
        alamat.setText(getString(R.string.sinderalt));
        desa.setText(getText(R.string.wanareja));
        judulartikel.setText(getString(R.string.sindertitle));
        alamatartikel.setText(getString(R.string.sinderalt));
        desaartikel.setText(getString(R.string.wanareja));
        isiartikel.setText(Html.fromHtml(getString(R.string.sinderdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.4149202 + ","
                                + 108.7234116));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.4149202 + ","
                                + 108.7234116));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noimage();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.sindertitle));

    }

    private void navstacil() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stacil)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstacil.showInfoWindow();
        image_cover.setImageResource(R.drawable.stacil1);
        judul.setText(getString(R.string.staciltitle));
        alamat.setText(getString(R.string.stacilalt));
        desa.setText(getText(R.string.cilacap_selatan));
        judulartikel.setText(getString(R.string.staciltitle));
        alamatartikel.setText(getString(R.string.stacilalt));
        desaartikel.setText(getString(R.string.cilacap_selatan));
        isiartikel.setText(Html.fromHtml(getString(R.string.stacildes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7360465 + ","
                                + 109.0070703));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.7360465 + ","
                                + 109.0070703));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystacil();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.staciltitle));

    }

    private void navstakesugihan() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stakesugihan)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstakesugihan.showInfoWindow();
        image_cover.setImageResource(R.drawable.stakesugihan1);
        judul.setText(getString(R.string.stakesugihantitle));
        alamat.setText(getString(R.string.stakesugihanalt));
        desa.setText(getText(R.string.kesugihan));
        judulartikel.setText(getString(R.string.stakesugihantitle));
        alamatartikel.setText(getString(R.string.stakesugihanalt));
        desaartikel.setText(getString(R.string.kesugihan));
        isiartikel.setText(Html.fromHtml(getString(R.string.stakesugihandes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.61833 + ","
                                + 109.12167));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.61833 + ","
                                + 109.12167));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystakesugihan();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.stakesugihantitle));

    }

    private void navstakarang() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stakarang)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstakarang.showInfoWindow();
        image_cover.setImageResource(R.drawable.stakarang1);
        judul.setText(getString(R.string.stakarangtitle));
        alamat.setText(getString(R.string.stakarangalt));
        desa.setText(getText(R.string.kesugihan));
        judulartikel.setText(getString(R.string.stakarangtitle));
        alamatartikel.setText(getString(R.string.stakarangalt));
        desaartikel.setText(getString(R.string.kesugihan));
        isiartikel.setText(Html.fromHtml(getString(R.string.stakarangdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6662416 + ","
                                + 109.0757612));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6662416 + ","
                                + 109.0757612));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystakarang();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.stakarangtitle));

    }

    private void navstakroya() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stakroya)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstakroya.showInfoWindow();
        image_cover.setImageResource(R.drawable.stakroya1);
        judul.setText(getString(R.string.stakroyatitle));
        alamat.setText(getString(R.string.stakroyaalt));
        desa.setText(getText(R.string.kroya));
        judulartikel.setText(getString(R.string.stakroyatitle));
        alamatartikel.setText(getString(R.string.stakroyaalt));
        desaartikel.setText(getString(R.string.kroya));
        isiartikel.setText(Html.fromHtml(getString(R.string.stakroyades)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.439192 + ","
                                + 108.7894434));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.439192 + ","
                                + 108.7894434));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystakroya();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.stakroyatitle));

    }

    private void navstamaos() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stamaos)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstamaos.showInfoWindow();
        image_cover.setImageResource(R.drawable.stamaos1);
        judul.setText(getString(R.string.stamaostitle));
        alamat.setText(getString(R.string.stamaosalt));
        desa.setText(getText(R.string.maos));
        judulartikel.setText(getString(R.string.stamaostitle));
        alamatartikel.setText(getString(R.string.stamaosalt));
        desaartikel.setText(getString(R.string.maos));
        isiartikel.setText(Html.fromHtml(getString(R.string.stamaosdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.619092 + ","
                                + 109.1394733));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.619092 + ","
                                + 109.1394733));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystamaos();
            }
        });

        collapsingToolbarLayout.setTitle(getString(R.string.stamaostitle));

    }

    private void navstagumilir() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stagumilir)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstagumilir.showInfoWindow();
        image_cover.setImageResource(R.drawable.stagumilir1);
        judul.setText(getString(R.string.stagumilirtitle));
        alamat.setText(getString(R.string.stagumiliralt));
        desa.setText(getText(R.string.gumilir));
        judulartikel.setText(getString(R.string.stagumilirtitle));
        alamatartikel.setText(getString(R.string.stagumiliralt));
        desaartikel.setText(getString(R.string.gumilir));
        isiartikel.setText(Html.fromHtml(getString(R.string.stagumilirdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6851217 + ","
                                + 109.042539));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6851217 + ","
                                + 109.042539));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystagumilir();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.stagumilirtitle));
    }

    private void navstajeruk() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stajeruk)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstajeruk.showInfoWindow();
        image_cover.setImageResource(R.drawable.stajeruk1);
        judul.setText(getString(R.string.stajeruktitle));
        alamat.setText(getString(R.string.stajerukalt));
        desa.setText(getText(R.string.jeruk));
        judulartikel.setText(getString(R.string.stajeruktitle));
        alamatartikel.setText(getString(R.string.stajerukalt));
        desaartikel.setText(getString(R.string.jeruk));
        isiartikel.setText(Html.fromHtml(getString(R.string.stajerukdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6238938 + ","
                                + 109.0194841));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.6238938 + ","
                                + 109.0194841));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystajeruk();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.stajeruktitle));

    }

    private void navstakawu() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stakawu)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstakawu.showInfoWindow();
        image_cover.setImageResource(R.drawable.stakawu1);
        judul.setText(getString(R.string.stakawutitle));
        alamat.setText(getString(R.string.stakawualt));
        desa.setText(getText(R.string.kawu));
        judulartikel.setText(getString(R.string.stakawutitle));
        alamatartikel.setText(getString(R.string.stakawualt));
        desaartikel.setText(getString(R.string.kawu));
        isiartikel.setText(Html.fromHtml(getString(R.string.stakawudes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.590806 + ","
                                + 108.919277));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.590806 + ","
                                + 108.919277));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystakawu();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.stakawutitle));

    }

    private void navstagandrung() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stagandrung)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstagandrung.showInfoWindow();
        image_cover.setImageResource(R.drawable.stagandrung1);
        judul.setText(getString(R.string.stagandrungtitle));
        alamat.setText(getString(R.string.stagandrungalt));
        desa.setText(getText(R.string.gandrung));
        judulartikel.setText(getString(R.string.stagandrungtitle));
        alamatartikel.setText(getString(R.string.stagandrungalt));
        desaartikel.setText(getString(R.string.gandrung));
        isiartikel.setText(Html.fromHtml(getString(R.string.stagandrungdes)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.527691 + ","
                                + 108.858765));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.527691 + ","
                                + 108.858765));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystagandrung();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.stagandrungtitle));

    }

    private void navstasidareja() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stasidareja)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstasidareja.showInfoWindow();
        image_cover.setImageResource(R.drawable.stasidareja1);
        judul.setText(getString(R.string.stasidarejatitle));
        alamat.setText(getString(R.string.stasidarejaalt));
        desa.setText(getText(R.string.sidareja));
        judulartikel.setText(getString(R.string.stasidarejatitle));
        alamatartikel.setText(getString(R.string.stasidarejaalt));
        desaartikel.setText(getString(R.string.sidareja));
        isiartikel.setText(Html.fromHtml(getString(R.string.stasidarejades)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.4863447 + ","
                                + 108.8075186));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.4863447 + ","
                                + 108.8075186));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystasidareja();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.stasidarejatitle));

    }

    private void navstacipari() {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(stacipari)
                .zoom(15)
                .tilt(30)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mstacipari.showInfoWindow();
        image_cover.setImageResource(R.drawable.stacipari1);
        judul.setText(getString(R.string.staciparititle));
        alamat.setText(getString(R.string.staciparialt));
        desa.setText(getText(R.string.cipari));
        judulartikel.setText(getString(R.string.staciparititle));
        alamatartikel.setText(getString(R.string.staciparialt));
        desaartikel.setText(getString(R.string.cipari));
        isiartikel.setText(Html.fromHtml(getString(R.string.staciparides)));
        arah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.440304 + ","
                                + 108.7610842));
                startActivity(i);
            }
        });
        arahsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW, Uri
                        .parse("http://maps.google.com/maps?daddr=" + -7.440304 + ","
                                + 108.7610842));
                startActivity(i);
            }
        });
        galeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportActionBar().hide();
                imagePager.setVisibility(View.VISIBLE);
                artikel.setVisibility(View.GONE);
                gallerystacipari();
            }
        });
        collapsingToolbarLayout.setTitle(getString(R.string.staciparititle));

    }


    //</editor-fold>

    //fsdshfynsdbyndfyjd

    //<editor-fold desc="gallery">

    private void setTextIndicator() {
        TextIndicator indicator = new TextIndicator(this);
        imagePager.setIndicator(indicator);
    }

    public void gallerybenteng() {
        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());
        mAdapter = new SimpleImagePagerAdapter(this);
        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();
        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://res.cloudinary.com/kucingapes/image/upload/v1507783561/benteng1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://res.cloudinary.com/kucingapes/image/upload/v1507855919/benteng4.jpg");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://res.cloudinary.com/kucingapes/image/upload/v1507856408/benteng/benteng5.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://res.cloudinary.com/kucingapes/image/upload/v1507856410/benteng/benteng6.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://res.cloudinary.com/kucingapes/image/upload/v1507856407/benteng/benteng7.png");
        images.add(image5);

        SimpleImagePagerAdapter.Image image6 = new SimpleImagePagerAdapter.Image();
        image6.setImageUrl("http://res.cloudinary.com/kucingapes/image/upload/v1507856411/benteng/benteng8.png");
        images.add(image6);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerybenling() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/benling/benling1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/benling/benling2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/benling/benling3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/benling/benling4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/benling/benling5.png");
        images.add(image5);

        SimpleImagePagerAdapter.Image image6 = new SimpleImagePagerAdapter.Image();
        image6.setImageUrl("http://kucingapes.ml/repocilacap/benling/benling6.png");
        images.add(image6);

        mAdapter.setImages(images);

        imagePager.setAdapter(mAdapter);

        setTextIndicator();

        imagePager.setIndicatorMargin(16);
    }

    public void gallerylapas() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/lapas/lapas1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/lapas/lapas2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/lapas/lapas3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/lapas/lapas4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/lapas/lapas5.png");
        images.add(image5);

        SimpleImagePagerAdapter.Image image6 = new SimpleImagePagerAdapter.Image();
        image6.setImageUrl("http://kucingapes.ml/repocilacap/lapas/lapas6.png");
        images.add(image6);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerybenkar() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/benkar/benkar1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/benkar/benkar2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/benkar/benkar3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/benkar/benkar4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/benkar/benkar5.png");
        images.add(image5);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void galleryklenteng() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/klenteng/klenteng1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/klenteng/klenteng2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/klenteng/klenteng3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/klenteng/klenteng4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/klenteng/klenteng5.png");
        images.add(image5);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void galleryteluk() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/teluk/teluk1.png");
        images.add(image1);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerypasir() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/pasir/pasir1.png");
        images.add(image1);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void galleryalun() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/alun/alun1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/alun/alun2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/alun/alun3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/alun/alun4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/alun/alun5.png");
        images.add(image5);

        SimpleImagePagerAdapter.Image image6 = new SimpleImagePagerAdapter.Image();
        image6.setImageUrl("http://kucingapes.ml/repocilacap/alun/alun6.png");
        images.add(image6);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerykerkhoff() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/kerkhoff/kerkhoff1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/kerkhoff/kerkhoff2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/kerkhoff/kerkhoff3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/kerkhoff/kerkhoff4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/kerkhoff/kerkhoff5.png");
        images.add(image5);

        SimpleImagePagerAdapter.Image image6 = new SimpleImagePagerAdapter.Image();
        image6.setImageUrl("http://kucingapes.ml/repocilacap/kerkhoff/kerkhoff6.png");
        images.add(image6);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void galleryptpn() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/ptpn/ptpn1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/ptpn/ptpn2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/ptpn/ptpn3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/ptpn/ptpn4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/ptpn/ptpn5.png");
        images.add(image5);

        SimpleImagePagerAdapter.Image image6 = new SimpleImagePagerAdapter.Image();
        image6.setImageUrl("http://kucingapes.ml/repocilacap/ptpn/ptpn6.png");
        images.add(image6);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerymasjid() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/masjid/masjid1.png");
        images.add(image1);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerysrandil() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/srandil/srandil1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/srandil/srandil2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/srandil/srandil3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/srandil/srandil4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/srandil/srandil5.png");
        images.add(image5);

        SimpleImagePagerAdapter.Image image6 = new SimpleImagePagerAdapter.Image();
        image6.setImageUrl("http://kucingapes.ml/repocilacap/srandil/srandil6.png");
        images.add(image6);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void galleryselok() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/selok/selok1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/selok/selok2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/selok/selok3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/selok/selok.png");
        images.add(image4);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerysodong() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/sodong/sodong1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/sodong/sodong2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/sodong/sodong3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/sodong/sodong4.png");
        images.add(image4);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerysudarman() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/sudarman/sudarman1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/sudarman/sudarman2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/sudarman/sudarman3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/sudarman/sudarman4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/sudarman/sudarman5.png");
        images.add(image5);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerypadang() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/padang/padang1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/padang/padang2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/padang/padang3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/padang/padang4.png");
        images.add(image4);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerymaria() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/maria/maria1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/maria/maria2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/maria/maria3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/maria/maria4.png");
        images.add(image4);


        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerymasigit() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/masigit/masigit1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/masigit/masigit2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/masigit/masigit3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/masigit/masigit4.png");
        images.add(image4);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void galleryjambu() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/jambu/jambu1.JPG");
        images.add(image1);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystacil() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stacil/stacil1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stacil/stacil2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/stacil/stacil3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/stacil/stacil4.png");
        images.add(image4);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystakesugihan() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stakesugihan/stakesugihan1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stakesugihan/stakesugihan2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/stakesugihan/stakesugihan3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/stakesugihan/stakesugihan4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/stakesugihan/stakesugihan5.png");
        images.add(image5);

        SimpleImagePagerAdapter.Image image6 = new SimpleImagePagerAdapter.Image();
        image6.setImageUrl("http://kucingapes.ml/repocilacap/stakesugihan/stakesugihan6.png");
        images.add(image6);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystakarang() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stakarang/stakarang1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stakarang/stakarang2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/stakarang/stakarang3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/stakarang/stakarang4.png");
        images.add(image4);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystakroya() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stakroya/stakroya1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stakroya/stakroya2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/stakroya/stakroya3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/stakroya/stakroya4.png");
        images.add(image4);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystamaos() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stamaos/stamaos1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stamaos/stamaos2.png");
        images.add(image2);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystagumilir() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stagumilir/stagumilir1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stagumilir/stagumilir2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/stagumilir/stagumilir3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/stagumilir/stagumilir4.png");
        images.add(image4);

        SimpleImagePagerAdapter.Image image5 = new SimpleImagePagerAdapter.Image();
        image5.setImageUrl("http://kucingapes.ml/repocilacap/stagumilir/stagumilir5.png");
        images.add(image5);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystajeruk() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stajeruk/stajeruk1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stajeruk/stajeruk2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/stajeruk/stajeruk3.png");
        images.add(image3);

        SimpleImagePagerAdapter.Image image4 = new SimpleImagePagerAdapter.Image();
        image4.setImageUrl("http://kucingapes.ml/repocilacap/stajeruk/stajeruk4.png");
        images.add(image4);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystakawu() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stakawu/stakawu1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stakawu/stakawu2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/stakawu/stakawu3.png");
        images.add(image3);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystagandrung() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stagandrung/stagandrung1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stagandrung/stagandrung2.png");
        images.add(image2);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystasidareja() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();

        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stasidareja/stasidareja1.png");
        images.add(image1);

        SimpleImagePagerAdapter.Image image2 = new SimpleImagePagerAdapter.Image();
        image2.setImageUrl("http://kucingapes.ml/repocilacap/stasidareja/stasidareja2.png");
        images.add(image2);

        SimpleImagePagerAdapter.Image image3 = new SimpleImagePagerAdapter.Image();
        image3.setImageUrl("http://kucingapes.ml/repocilacap/stasidareja/stasidareja3.png");
        images.add(image3);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }

    public void gallerystacipari() {

        imagePager.setPageTransformer(true, new ZoomOutPageTransformer());

        mAdapter = new SimpleImagePagerAdapter(this);

        mAdapter.setScaleType(null);
        ArrayList<SimpleImagePagerAdapter.Image> images = new ArrayList<>();


        SimpleImagePagerAdapter.Image image1 = new SimpleImagePagerAdapter.Image();
        image1.setImageUrl("http://kucingapes.ml/repocilacap/stacipari/stacipari1.png");
        images.add(image1);

        mAdapter.setImages(images);
        imagePager.setAdapter(mAdapter);
        setTextIndicator();
        imagePager.setIndicatorMargin(16);
    }
    //</editor-fold>
}

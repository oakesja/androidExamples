package com.example.joakes.pageviewexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends FragmentActivity {

    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Website[] websites = new Website[]{
                new Website("Google", "https://www.google.com"),
                new Website("IGN", "http://www.ign.com/"),
                new Website("Amazon", "http://www.amazon.com/"),
                new Website("Ebay", "http://www.ebay.com/")
        };

        mDemoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager(), websites);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);
    }

    public class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {
        private Website[] mWebSites;

        public DemoCollectionPagerAdapter(FragmentManager fm, Website[] websites) {
            super(fm);
            mWebSites = websites;
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new DemoObjectFragment();
            Bundle args = new Bundle();
            args.putString(DemoObjectFragment.ARG_OBJECT, mWebSites[i].getUrl());
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return mWebSites.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mWebSites[position].getTitle();
        }
    }

    public static class DemoObjectFragment extends Fragment {
        public static final String ARG_OBJECT = "object1";

        @Override
        public View onCreateView(LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(
                    R.layout.web_fragment, container, false);
            Bundle args = getArguments();
            WebView webView = (WebView)rootView.findViewById(R.id.webView);
            webView.setWebViewClient(new WebViewClient());
            webView.setHorizontalScrollBarEnabled(true);
            webView.loadUrl(args.getString(ARG_OBJECT));
            return rootView;
        }
    }
}
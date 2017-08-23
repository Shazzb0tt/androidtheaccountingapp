package larmour.daniel.theaccountingapp.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import io.reactivex.disposables.CompositeDisposable;
import larmour.daniel.theaccountingapp.R;

/**
 * Main screen of the app
 */
public class MainActivity extends LifecycleActivity implements AppCompatCallback {
    private static final String TAG = MainActivity.class.getSimpleName();

    private       ViewModelFactory    mViewModelFactory;
    private       UserViewModel       mViewModel;
    private final CompositeDisposable mDisposable = new CompositeDisposable();
    private       AppCompatDelegate   mDelegate;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAppBar(savedInstanceState);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setupAppBar(Bundle savedInstanceState) {
        // Because we can't use AppCompatActivity
        mDelegate = AppCompatDelegate.create(this, this);
        mDelegate.onCreate(savedInstanceState);
        mDelegate.setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.layout_toolbar);
        toolbar.inflateMenu(R.menu.settings);
        mDelegate.setSupportActionBar(toolbar);
        if(mDelegate.getSupportActionBar() != null) {
            mDelegate.getSupportActionBar().setTitle(TAG);
        }
    }

    private void goToProfileActivity() {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(mDelegate.getSupportActionBar() != null) {
            getMenuInflater().inflate(R.menu.settings, menu);
        }
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_profile:
                goToProfileActivity();
                break;

        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onSupportActionModeStarted(ActionMode mode) {

    }

    @Override
    public void onSupportActionModeFinished(ActionMode mode) {

    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }
}
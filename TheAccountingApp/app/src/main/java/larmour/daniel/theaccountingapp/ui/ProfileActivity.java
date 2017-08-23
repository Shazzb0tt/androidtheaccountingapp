package larmour.daniel.theaccountingapp.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import larmour.daniel.theaccountingapp.Injection;
import larmour.daniel.theaccountingapp.R;

/**
 * Created by Daniel Larmour on 7/30/2017.
 * email at daniellarmour@hotmail.com
 */

public class ProfileActivity extends LifecycleActivity implements AppCompatCallback{
    private static final String TAG = ProfileActivity.class.getSimpleName();

    private       ViewModelFactory    mViewModelFactory;
    private       UserViewModel       mViewModel;
    private final CompositeDisposable mDisposable = new CompositeDisposable();
    private       AppCompatDelegate   mDelegate;

    private       TextView            mProfileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupAppBar(savedInstanceState);
        initializeViews();

        mViewModelFactory = Injection.provideViewModelFactory(ProfileActivity.this);
        mViewModel        = ViewModelProviders.of(ProfileActivity.this, mViewModelFactory)
                                              .get(UserViewModel.class);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mDisposable.add(mViewModel.getUserName()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull String s) throws Exception {
                        mProfileName.setText(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                        Log.e(TAG, "Unable to update username", throwable);
                    }
                }));
    }

    @Override
    protected void onStop() {
        super.onStop();

        mDisposable.clear();
    }

    private void setupAppBar(Bundle savedInstanceState) {
        // Because we can't use AppCompatActivity
        mDelegate = AppCompatDelegate.create(this, this);
        mDelegate.onCreate(savedInstanceState);
        mDelegate.setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.layout_toolbar);
        toolbar.inflateMenu(R.menu.settings);
        mDelegate.setSupportActionBar(toolbar);
        if(mDelegate.getSupportActionBar() != null) {
            mDelegate.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initializeViews() {
        mProfileName = (TextView) findViewById(R.id.tv_profile_name);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
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
package larmour.daniel.theaccountingapp.ui;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;

import io.reactivex.disposables.CompositeDisposable;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupAppBar(savedInstanceState);

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
            mDelegate.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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

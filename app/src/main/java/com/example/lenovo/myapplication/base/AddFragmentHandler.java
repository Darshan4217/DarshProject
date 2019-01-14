package com.example.lenovo.myapplication.base;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.lenovo.myapplication.R;

public class AddFragmentHandler {

    private final FragmentManager fragmentManager;

    AddFragmentHandler(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    /**
     * Add fragment to the frame layout.
     * @param fragment fragment instance to be added.
     */
    public void add(BaseFragment fragment) {

        //Don't add a fragment of the same type on top of itself.
        BaseFragment currentFragment = getCurrentFragment();
        if (currentFragment != null) {
            if (currentFragment.getClass() == fragment.getClass()) {
                Log.w("Fragment Manager", "Tried to add a fragment of the same type to the backstack. This may be done on purpose in some circumstances but generally should be avoided.");
                return;
            }
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment, fragment.getTitle());
        fragmentTransaction.addToBackStack(fragment.getTitle());
        fragmentTransaction.commit();
    }

    /**
     * This method will return current fragment available on top of the stack.
     * @return Fragment instance of type BaseFragment
     */
    @Nullable
    public BaseFragment getCurrentFragment() {

        // If Stack is empty, then no fragments available.
        if (fragmentManager.getBackStackEntryCount() == 0) {
            return null;
        }

        FragmentManager.BackStackEntry currentEntry = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1);

        String tag = currentEntry.getName();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        return (BaseFragment) fragment;
    }
}

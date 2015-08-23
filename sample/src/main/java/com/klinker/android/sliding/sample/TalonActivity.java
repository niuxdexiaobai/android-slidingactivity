/*
 * Copyright (C) 2015 Jacob Klinker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.klinker.android.sliding.sample;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

import com.klinker.android.sliding.SlidingActivity;

/**
 * Activity mocking out the profile page on Talon for Twitter and demonstrating the power of
 * sliding activities.
 */
public class TalonActivity extends SlidingActivity {

    /**
     * Initialize our values, this is overridden instead of onCreate as it should be in all
     * sliding activities.
     * @param savedInstanceState the saved state.
     */
    @Override
    public void init(Bundle savedInstanceState) {
        setTitle(R.string.talon_activity);

        setPrimaryColors(
                getResources().getColor(R.color.talon_activity_primary),
                getResources().getColor(R.color.talon_activity_primary_dark)
        );

        setContent(R.layout.activity_talon);

        // delay this so that the animation shows and we don't change the activity colors
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setImage(R.drawable.twitter_profile);
            }
        }, 500);

        setFab(
                getResources().getColor(R.color.talon_activity_accent),
                R.drawable.ic_add,
                null
        );
    }

    /**
     * Creates the options menu.
     * @param menu the menu.
     * @return true.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_talon, menu);
        return true;
    }

}

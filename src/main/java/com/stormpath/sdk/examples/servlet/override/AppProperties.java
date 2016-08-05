package com.stormpath.sdk.examples.servlet.override;

import com.stormpath.sdk.lang.Strings;

/**
 * Date: 8/5/16
 */
public class AppProperties {

    protected static final String COMMUNITY_EDITION = "COMMUNITY";
    protected static final String COMMERCIAL_EDITION = "COMMERCIAL";

    public static final boolean STORMPATH_ENABLED;

    static {
        String appEdition = System.getenv("APP_EDITION");
        if (Strings.hasText(appEdition) && appEdition.equals(COMMERCIAL_EDITION)) {
            STORMPATH_ENABLED = true;
        } else {
            STORMPATH_ENABLED = false;
        }
    }
}

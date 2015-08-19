package net.azurewebsites.farmtrace;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by sebichondo on 8/14/15.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface MainScope {
}

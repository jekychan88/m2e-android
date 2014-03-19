/*******************************************************************************
 * Copyright (c) 2009, 2010, 2014 Ricardo Gladwell and Hugo Josefson
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package me.gladwell.eclipse.m2e.android;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class AndroidMavenPlugin extends Plugin {

	public static final String PLUGIN_ID = "me.gladwell.eclipse.m2e.android";
	public static final String APKLIB_ERROR_TYPE = "me.gladwell.eclipse.m2e.android.markers.dependency.apklib";
    public static final String CONTAINER_NONRUNTIME_DEPENDENCIES = "me.gladwell.eclipse.m2e.android.classpath.NONRUNTIME_DEPENDENCIES";

	private static AndroidMavenPlugin plugin;

	private Injector injector;

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static AndroidMavenPlugin getDefault() {
		return plugin;
	}

	public Injector getInjector() {
		if(injector == null) {
			injector = Guice.createInjector(new PluginModule());
		}
		return injector;
	}

}

/*******************************************************************************
 * Copyright (c) 2015 Jens Reimann.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package de.dentrassi.pm.importer.http.web;

import com.google.gson.GsonBuilder;

public class TestResult
{
    private static final GsonBuilder builder = new GsonBuilder ();

    private int returnCode;

    private String name;

    public void setName ( final String name )
    {
        this.name = name;
    }

    public String getName ()
    {
        return this.name;
    }

    public void setReturnCode ( final int returnCode )
    {
        this.returnCode = returnCode;
    }

    public int getReturnCode ()
    {
        return this.returnCode;
    }

    public static TestResult fromJson ( final String json )
    {
        return builder.create ().fromJson ( json, TestResult.class );
    }
}

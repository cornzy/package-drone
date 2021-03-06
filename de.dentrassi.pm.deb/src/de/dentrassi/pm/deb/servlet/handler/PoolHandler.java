/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package de.dentrassi.pm.deb.servlet.handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.google.common.io.ByteStreams;

import de.dentrassi.pm.storage.service.StorageService;
import de.dentrassi.pm.storage.service.util.DownloadHelper;

public class PoolHandler implements Handler
{
    private final String artifactId;

    private final String name;

    private final StorageService service;

    public PoolHandler ( final StorageService service, final String artifactId, final String name )
    {
        this.service = service;
        this.artifactId = artifactId;
        this.name = name;
    }

    @Override
    public void process ( final HttpServletResponse response ) throws IOException
    {
        if ( this.artifactId == null || this.artifactId.isEmpty () )
        {
            response.setContentType ( "text/plain" );
            response.getWriter ().println ( "Browsing the pool is currently not supported" );
            return;
        }

        DownloadHelper.streamArtifact ( response, this.service, this.artifactId, null, true, info -> this.name );
    }

    @Override
    public void process ( final OutputStream stream ) throws IOException
    {
        if ( !this.service.streamArtifact ( this.artifactId, ( ai, in ) -> ByteStreams.copy ( in, stream ) ) )
        {
            throw new FileNotFoundException ( this.artifactId );
        }
    }

}

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
package de.dentrassi.pm.p2.internal.aspect;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import de.dentrassi.pm.common.ArtifactInformation;

public class DocumentCache
{
    @FunctionalInterface
    public interface DocumentConsumer
    {
        public void accept ( ArtifactInformation information, Document document ) throws Exception;
    }

    private final Map<String, Document> cacheMap = new HashMap<> ( 1024 );

    private final DocumentBuilder documentBuilder;

    public DocumentCache ( final DocumentBuilder documentBuilder )
    {
        this.documentBuilder = documentBuilder;
    }

    public void stream ( final ArtifactInformation artifact, final ArtifactStreamer streamer, final DocumentConsumer consumer ) throws Exception
    {
        final String key = artifact.getId ();

        final Document doc = this.cacheMap.get ( key );
        if ( doc != null )
        {
            consumer.accept ( artifact, doc );
        }
        else
        {
            streamer.stream ( artifact.getId (), stream -> {
                final Document newDoc = this.documentBuilder.parse ( stream );
                this.cacheMap.put ( key, newDoc );
                consumer.accept ( artifact, newDoc );
            } );
        }
    }

}

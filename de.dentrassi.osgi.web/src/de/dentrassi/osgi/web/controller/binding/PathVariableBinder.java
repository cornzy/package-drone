/*******************************************************************************
 * Copyright (c) 2014, 2015 Jens Reimann.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package de.dentrassi.osgi.web.controller.binding;

import de.dentrassi.osgi.converter.ConverterManager;
import de.dentrassi.osgi.web.controller.routing.RequestMappingInformation.Match;

public class PathVariableBinder implements Binder
{
    private final Match match;

    public PathVariableBinder ( final Match match )
    {
        this.match = match;
    }

    @Override
    public Binding performBind ( final BindTarget target, final ConverterManager converter, final BindingManager bindingManager )
    {
        final PathVariable pv = target.getAnnotation ( PathVariable.class );
        if ( pv == null )
        {
            return null;
        }

        final String valueString = this.match.getAttributes ().get ( pv.value () );

        try
        {
            final Object value = converter.convertTo ( valueString, target.getType () );
            return Binding.simpleBinding ( value );
        }
        catch ( final Exception e )
        {
            return Binding.errorBinding ( e );
        }
    }
}

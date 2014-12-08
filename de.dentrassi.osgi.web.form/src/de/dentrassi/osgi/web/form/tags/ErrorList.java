package de.dentrassi.osgi.web.form.tags;

import java.util.List;

import javax.servlet.jsp.JspException;

import de.dentrassi.osgi.web.controller.binding.BindingError;

public class ErrorList extends FormValueTagSupport
{
    private static final long serialVersionUID = 1L;

    @Override
    public int doStartTag () throws JspException
    {
        final List<BindingError> errors = getErrors ();

        if ( this.skipIfEmpty && errors.isEmpty () )
        {
            return SKIP_BODY;
        }

        final WriterHelper writer = new WriterHelper ( this.pageContext );

        writer.write ( "<ul" );
        writeDefaultAttributes ( writer );
        writer.write ( ">" );

        for ( final BindingError error : errors )
        {
            writer.write ( "<li>" );
            writer.writeEscaped ( error.getMessage () );
            writer.write ( "</li>" );
        }

        writer.write ( "</ul>" );

        return SKIP_BODY;
    }

    private boolean skipIfEmpty = true;

    public void setSkipIfEmpty ( final boolean skipIfEmpty )
    {
        this.skipIfEmpty = skipIfEmpty;
    }
}
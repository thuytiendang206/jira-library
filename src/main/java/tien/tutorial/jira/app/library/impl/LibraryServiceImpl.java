package tien.tutorial.jira.app.library.impl;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;
import tien.tutorial.jira.app.library.api.LibraryService;

import javax.inject.Inject;
import javax.inject.Named;

@ExportAsService ({LibraryService.class})
@Named ("libraryService")
public class LibraryServiceImpl implements LibraryService
{
    @ComponentImport
    private final ApplicationProperties applicationProperties;

    @Inject
    public LibraryServiceImpl(final ApplicationProperties applicationProperties)
    {
        this.applicationProperties = applicationProperties;
    }

    public String getName()
    {
        if(null != applicationProperties)
        {
            return "libraryService:" + applicationProperties.getDisplayName();
        }
        
        return "libraryService";
    }
}
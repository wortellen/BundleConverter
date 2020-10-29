package ru.ncedu.wortellen.utils2.bundleconverter;
import java.util.ListResourceBundle;


/**
 * Resource bundle with general strings (concerning files).
 * This implementation is used if the current user locale is Russian (ru_RU).
 * Note that the encoding of this source file is Cp1251 (windows-1251)
 *  so this bundle is compiled correctly only on computers with russian locale.
 *  Such an approach is not recommended: use UTF-8 encoding for all sources!
 */
public class Bundle extends ListResourceBundle {
    /**
     * @see java.util.ListResourceBundle
     */
    protected final Object[][] getContents() {
        return new Object[][]{
                {"Error", "Error"},
                {"File", "File"},
                {"inFile", "in file"},
                {"notFound", "not found"},
                {"CantDelete", "Can't delete"},
                {"CantCreate", "Can't create"}//not used yet
        };
    }
}



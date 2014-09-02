/**
 * OLAT - Online Learning and Training<br>
 * http://www.olat.org
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); <br>
 * you may not use this file except in compliance with the License.<br>
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,<br>
 * software distributed under the License is distributed on an "AS IS" BASIS, <br>
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br>
 * See the License for the specific language governing permissions and <br>
 * limitations under the License.
 * <p>
 * Copyright (c) 1999-2006 at Multimedia- & E-Learning Services (MELS),<br>
 * University of Zurich, Switzerland.
 * <p>
 */

package org.olat.presentation.framework.core.translator;

import java.util.Locale;

import org.apache.log4j.Level;

/**
 * Description:<br>
 * TODO: schneider Class Description for HeaderColumnTranslator
 * <P>
 * Initial Date: 19.12.2005 <br>
 * 
 * @author Alexander Schneider
 */
public class HeaderColumnTranslator implements Translator {
    private Translator origTranslator;

    public HeaderColumnTranslator(Translator origTranslator) {
        this.origTranslator = origTranslator;
    }

    @Override
    public String translate(String key) {
        return this.translate(key, null);
    }

    @Override
    public String translate(String key, String[] args) {
        return translate(key, args, Level.WARN);
    }

    @Override
    public String translate(String key, String[] args, Level missingTranslationLogLevel) {
        String val;
        if (key.startsWith("ccc")) {
            String t = key.substring(3);
            val = origTranslator.translate("column", new String[] { t });
        } else if (key.startsWith("hhh")) {
            val = key.substring(3);
        } else {
            val = origTranslator.translate(key);
        }
        return val;
    }

    /**
	 */
    @Override
    public String translate(String key, String[] args, boolean fallBackToDefaultLocale) {
        // no fall back to default locale
        return translate(key, args);
    }

    @Override
    public Locale getLocale() {
        return origTranslator.getLocale();
    }

    @Override
    public void setLocale(Locale locale) {
        origTranslator.setLocale(locale);
    }

}

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

package org.olat.data.commons.xml;

import java.io.InputStream;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/**
 * @author mike To change this generated comment edit the template variable "typecomment": Window>Preferences>Java>Templates. To enable and disable the creation of type
 *         comments go to Window>Preferences>Java>Code Generation.
 */
public class DefaultEntityResolver implements EntityResolver {

    /**
	 * 
	 */
    public DefaultEntityResolver() {
        //
    }

    /**
	 */
    @Override
    public InputSource resolveEntity(String publicId, String systemId) {
        InputStream in = getClass().getResourceAsStream("/org/olat/system/util/xml/" + systemId);
        if (in == null)
            throw new RuntimeException("systemId '" + systemId + "', pubId " + publicId + " could not be resolved by OLAT");
        return new InputSource(in);
    }
}

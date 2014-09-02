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
 * Copyright (c) since 2004 at Multimedia- & E-Learning Services (MELS),<br>
 * University of Zurich, Switzerland.
 * <p>
 */
package org.olat.lms.properties;

import java.util.List;

import org.olat.data.basesecurity.Identity;
import org.olat.data.properties.PropertyImpl;
import org.olat.data.properties.PropertyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PropertyService
 * 
 * <P>
 * Initial Date: 07.07.2011 <br>
 * 
 * @author guido
 */
@Service
public class PropertyService {

    @Autowired
    PropertyManager propertyManager;

    /**
     * [spring]
     */
    protected PropertyService() {
        //
    }

    /**
     * @param identity
     * @return
     */
    public List<PropertyImpl> listProperties(Identity identity) {
        if (identity == null)
            throw new IllegalArgumentException();
        return propertyManager.listProperties(identity, null, null, null, null);
    }

    /**
     * @param property
     */
    public void deleteProperty(PropertyImpl property) {
        propertyManager.deleteProperty(property);
    }

}

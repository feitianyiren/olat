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
package org.olat.system.commons.configuration;

/**
 * Description:<br>
 * common interface for spring triggered init methods Spring triggers init methods after the instance is created. If you depend on any other functionality at construction
 * or init time inject it via spring or ad the depends-on attribute
 * <P>
 * Initial Date: 17.03.2010 <br>
 * 
 * @author guido
 */
public interface Initializable {

    /**
     * <bean class="org.olat ....XY" init-method="init"> must be called manuall in the spring config file or if you like the annotations way add a @PostConstruct to the
     * method
     */
    public void init();

}

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

package ch.goodsolutions.olat.intranetsite;

import org.olat.presentation.framework.core.UserRequest;
import org.olat.presentation.framework.core.control.WindowControl;
import org.olat.presentation.framework.core.control.navigation.AbstractSiteDefinition;
import org.olat.presentation.framework.core.control.navigation.SiteDefinition;
import org.olat.presentation.framework.core.control.navigation.SiteInstance;

/**
 * Description:<br>
 * TODO: Felix Jost Class Description for HomeSite
 * <P>
 * Initial Date: 12.07.2005 <br>
 * 
 * @author Felix Jost
 */
public class SiteDef extends AbstractSiteDefinition implements SiteDefinition {
	private String repositorySoftKey;

	/**
	 * 
	 */
	public SiteDef() {
		//
	}

	/**
	 * @see org.olat.navigation.SiteDefinition#createSite(org.olat.presentation.framework.UserRequest, org.olat.presentation.framework.control.WindowControl)
	 */
	@Override
	public SiteInstance createSite(final UserRequest ureq, final WindowControl wControl) {
		// create the site for all users except for guests
		if (ureq.getUserSession().getRoles().isGuestOnly()) { return null; }
		return new Site(ureq.getLocale(), repositorySoftKey);
	}

	/**
	 * for SPRING
	 * 
	 * @param repositorySoftKey The repositorySoftKey to set.
	 */
	public void setRepositorySoftKey(final String repositorySoftKey) {
		this.repositorySoftKey = repositorySoftKey;
	}

}

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

package org.olat.lms.ims.qti.parser;

import java.util.List;

import org.dom4j.Element;
import org.olat.lms.ims.qti.objects.SelectionOrdering;
import org.olat.system.exception.OLATRuntimeException;

/**
 * Initial Date: Sep 23, 2003
 * 
 * @author gnaegi<br>
 *         Comment: Parser for the selection_ordering elements (at section level). Uses the number of choosen items from the selection_number element if available and the
 *         ordering type from the order element. Uses default values from the SelectionOrdering class in cases of non exising elements </pre>
 */
public class SelectionOrderingParser implements IParser {

    /**
	 */
    @Override
    public Object parse(final Element element) {
        // assert element.getName().equalsIgnoreCase("selection_ordering");

        final SelectionOrdering selectionOrdering = new SelectionOrdering();

        // Set correct selection of items. To select all is the default value (represented
        // by a non existing 'selection_number' element. Otherwhise the exact number given
        // in the 'selection_number' element is taken')
        final List el_selections = element.selectNodes("selection");
        if (el_selections.size() > 1) {
            // error
            throw new OLATRuntimeException(SelectionOrderingParser.class, "more then one selection element", new IllegalStateException());
        }
        if (el_selections.size() != 0) {
            final Element el_selection = ((Element) el_selections.get(0));
            final Element selection_number = (Element) el_selection.selectSingleNode("selection_number");

            if (selection_number != null) {
                selectionOrdering.setSelectionNumber(Integer.parseInt(selection_number.getText()));
            }
        }
        // else use default value

        // Set correct order type. Use sequential ordering als default if none defined
        final Element order = (Element) element.selectSingleNode("//order");
        if (order != null) {
            final String order_type = order.attributeValue(SelectionOrdering.ORDER_TYPE);
            if (order_type != null && order_type.equals(SelectionOrdering.RANDOM)) {
                selectionOrdering.setOrderType(SelectionOrdering.RANDOM);
                // else use default value
            }
        }

        return selectionOrdering;
    }
}

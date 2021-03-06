/*
 * Copyright 2014 geoSDI.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtopenmaps.openlayers.client.layer;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.gwtopenmaps.openlayers.client.util.JSObject;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
abstract class LayerCreatorStore {

    protected final Map<String, Layer.LayerCreator<? extends Layer>> registar = new HashMap<String, Layer.LayerCreator<? extends Layer>>();

    final boolean isLayerCreatorRegisterd(String classLayerName) {
        return this.registar.containsKey(classLayerName);
    }

    final Layer.LayerCreator<? extends Layer> getLayerCreator(
            String layerClassName) {
        return this.registar.get(layerClassName);
    }

    final Collection<Layer.LayerCreator<? extends Layer>> getAllLayerCreator() {
        return Collections.unmodifiableCollection(this.registar.values());
    }

    protected abstract void registerLayerCreator(Layer layer);

    protected abstract <L extends Layer> L createLayer(JSObject jsObject);

}

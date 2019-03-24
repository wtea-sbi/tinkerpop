/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.machine.traverser.species;

import org.apache.tinkerpop.machine.function.CFunction;
import org.apache.tinkerpop.machine.traverser.Traverser;
import org.apache.tinkerpop.machine.traverser.TraverserFactory;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class COP_TraverserFactory<C> implements TraverserFactory<C> {

    private static final COP_TraverserFactory INSTANCE = new COP_TraverserFactory();

    private COP_TraverserFactory() {
        // static instance
    }

    @Override
    public <S> Traverser<C, S> create(final CFunction<C> function, final S object) {
        final COP_Traverser<C, S> traverser = new COP_Traverser<>(function.coefficient(), object);
        traverser.path().add(function.label(), object);
        return traverser;
    }

    public static <C> COP_TraverserFactory<C> instance() {
        return INSTANCE;
    }
}

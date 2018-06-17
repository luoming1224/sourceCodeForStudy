/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.pool2;

/**
 * Provides the possible states that a {@link PooledObject} may be in.
 *
 * @since 2.0
 */
public enum PooledObjectState {
    /**
     * In the queue, not in use.    位于队列中，未使用
     */
    IDLE,

    /**
     * In use.      在使用
     */
    ALLOCATED,

    /**
     * In the queue, currently being tested for possible eviction.　位于队列中，当前正在测试，可能被回收（驱逐）
     */
    EVICTION,

    /**
     * Not in the queue, currently being tested for possible eviction. An
     * attempt to borrow the object was made while being tested which removed it
     * from the queue. It should be returned to the head of the queue once
     * eviction testing completes.
     * TODO: Consider allocating object and ignoring the result of the eviction
     *       test.
     */
    EVICTION_RETURN_TO_HEAD,

    /**
     * In the queue, currently being validated.　位于队列中，当前正在验证
     */
    VALIDATION,

    /**
     * Not in queue, currently being validated. The object was borrowed while
     * being validated and since testOnBorrow was configured, it was removed
     * from the queue and pre-allocated. It should be allocated once validation
     * completes.
     */
    VALIDATION_PREALLOCATED,

    /**
     * Not in queue, currently being validated. An attempt to borrow the object
     * was made while previously being tested for eviction which removed it from
     * the queue. It should be returned to the head of the queue once validation
     * completes.
     */
    VALIDATION_RETURN_TO_HEAD,

    /**
     * Failed maintenance (e.g. eviction test or validation) and will be / has
     * been destroyed　回收测试或者验证失败，将销毁
     */
    INVALID,

    /**
     * Deemed abandoned, to be invalidated.　被视为被遗弃的，被宣告无效
     */
    ABANDONED,

    /**
     * Returning to the pool.　返回到池中
     */
    RETURNING
}

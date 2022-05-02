/*
 * Copyright 2020 The Android Open Source Project
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

package app.cash.paging

import kotlin.jvm.JvmName

expect abstract class RemoteMediator<Key : Any, Value : Any> {
  abstract suspend fun load(
    loadType: LoadType,
    state: PagingState<Key, Value>
  ): MediatorResult

  open suspend fun initialize(): InitializeAction
}

expect sealed class MediatorResult

expect class MediatorResultError(throwable: Throwable) {
  val throwable: Throwable
}

expect class MediatorResultSuccess(
  endOfPaginationReached: Boolean
) {
  @get:JvmName("endOfPaginationReached")
  val endOfPaginationReached: Boolean
}

expect enum class InitializeAction {
  LAUNCH_INITIAL_REFRESH,

  SKIP_INITIAL_REFRESH
}

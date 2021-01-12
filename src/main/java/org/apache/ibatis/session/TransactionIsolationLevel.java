/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.session;

import java.sql.Connection;

/**
 * @author Clinton Begin
 * 事务隔离级别枚举
 */
public enum TransactionIsolationLevel {
  /** 0:默认取决于数据库的事务 */
  NONE(Connection.TRANSACTION_NONE),
  /** 1:Mybatis层面的读已提交 */
  READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
  /** 2:Mybatis层面的读未提交 */
  READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
  /** 3:Mybatis层面的可重复读 */
  REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
  /** 4:Mybatis层面的串行化 */
  SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

  private final int level;

  private TransactionIsolationLevel(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }
}

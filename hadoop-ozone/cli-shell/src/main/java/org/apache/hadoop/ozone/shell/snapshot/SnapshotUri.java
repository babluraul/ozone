/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.ozone.shell.snapshot;

import org.apache.hadoop.ozone.shell.OzoneAddress;
import org.apache.hadoop.ozone.shell.Shell;
import picocli.CommandLine;

/**
 * URI parameter for snapshot-specific commands.
 */
public class SnapshotUri implements CommandLine.ITypeConverter<OzoneAddress> {

  private static final String OZONE_SNAPSHOT_URI_DESCRIPTION =
      "URI of the volume/bucket/snapshot.\n" + Shell.OZONE_URI_DESCRIPTION;

  @CommandLine.Parameters(index = "0", arity = "1..1",
      description = OZONE_SNAPSHOT_URI_DESCRIPTION,
      converter = SnapshotUri.class)
  private OzoneAddress value;

  public OzoneAddress getValue() {
    return value;
  }

  @Override
  public OzoneAddress convert(String str) throws Exception {
    OzoneAddress address = new OzoneAddress(str);
    address.ensureSnapshotAddress();
    return address;
  }
}

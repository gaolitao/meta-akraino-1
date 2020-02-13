#
# Copyright (C) 2019 Wind River Systems, Inc.
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

DESCRIPTION = "An image suitable for Akraino REC."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit akraino-image akraino-iso

IMAGE_INSTALL += " \
    kernel-modules \
    packagegroup-akraino-base \
    packagegroup-akraino-docker \
    packagegroup-base-extended \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-self-hosted \
    packagegroup-stak-python \
    packagegroup-stak-base \
    packagegroup-stak-ruby \
    packagegroup-stak-puppet \
    packagegroup-vm \
"

IMAGE_FEATURES += " \
    nfs-server \
    package-management \
"

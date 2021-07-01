FROM docker.io/library/maven:3.8.1-openjdk-11 as build


COPY --chown=1000:0 . /tmp/app

RUN mvn package -f /tmp/app/pom.xml

# Start with OL runtime.
# tag::from[]
FROM openliberty/open-liberty:full-java11-openj9-ubi as runtime
# end::from[]

ARG VERSION=1.0
ARG REVISION=SNAPSHOT
# tag::label[]

LABEL \
  org.opencontainers.image.authors="Your Name" \
  org.opencontainers.image.vendor="IBM" \
  org.opencontainers.image.url="local" \
  org.opencontainers.image.source="https://github.com/OpenLiberty/guide-docker" \
  org.opencontainers.image.version="$VERSION" \
  org.opencontainers.image.revision="$REVISION" \
  vendor="Open Liberty" \
  name="system" \
  version="$VERSION-$REVISION" \
  summary="The system microservice from the Docker Guide" \
  # tag::description[]
  description="This image contains the system microservice running with the Open Liberty runtime."
  # end::description[]
# end::label[]

# tag::user-root[]
USER root
# end::user-root[]

# tag::copy[]
# COPY --chown=1001:0 src/main/liberty/config/server.xml /config/
# COPY --chown=1001:0 target/*.war /config/apps/
COPY --from=build --chown=1001:0 /tmp/app/src/main/liberty/config/server.xml /config/
COPY --from=build --chown=1001:0 /tmp/app/target/*.war /config/apps/
COPY --from=build --chown=1001:0 /tmp/app/target/liberty/wlp/usr/shared/resources/derby*.jar /liberty/usr/shared/resources/
# end::copy[]
# tag::user[]
USER 1001
# end::user[]
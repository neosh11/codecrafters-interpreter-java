#!/bin/sh

docker build -t codecrafters-java:latest . && \
docker run --rm codecrafters-java "$@"
# docker image prune -f
# docker rmi $(docker images --filter "dangling=false" --filter "reference=codecrafters-java:*" --format "{{.ID}}" | tail -n +2)
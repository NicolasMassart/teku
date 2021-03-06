# Changelog

## Upcoming Breaking Changes
- Teku currently publishes a `head` event on the REST API 4 seconds into a slot even if a block has not been received. In a future release this will be changed so `head` event is only published when a new
  chain head block is imported. The `--Xvalidators-dependent-root-enabled` option can be used to switch to the new behaviour now for testing.
  Note: this should be applied to both the beacon node and validator client if running separately.
- The `/teku/v1/beacon/states/:state_id` endpoint has been deprecated in favor of the standard API `/eth/v1/debug/beacon/states/:state_id` which now returns the state as SSZ when the `Accept: application/octet-stream` header is specified on the request.

## Current Releases
For information on changes in released versions of Teku, see the [releases page](https://github.com/ConsenSys/teku/releases).

## Unreleased Changes

### Additions and Improvements
- Include expected path for keystore password file in error message when password file is not found.
- Added additional bootnodes for Pyrmont testnet.
- Optimised how block production metrics are calculated.
- implement GET `/eth/v1/node/peer_count` standard api endpoint.

### Bug Fixes
- Fixed failures in the `checkMavenCoordinateCollisions` task if it was run prior to running spotless.

### Experimental: New Altair REST APIs
- implement POST `/eth/v1/beacon/pool/sync_committees` to allow validators to submit sync committee signatures to the beacon node.
- implement POST `/eth/v1/validator/duties/sync/{epoch}` for Altair fork.
- implement GET and POST `/eth/v1/validator/sync_committee_subscriptions` for Altair fork.
- implement GET `/eth/v2/validator/blocks/{slot}` for Altair fork.
- implement GET `/eth/v1/beacon/states/{state_id}/sync_committees` for Altair fork.
- `/eth/v1/validator/blocks/{slot}` will now produce an altair block if an altair slot is requested.
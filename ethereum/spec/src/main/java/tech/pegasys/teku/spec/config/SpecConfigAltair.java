/*
 * Copyright 2021 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.spec.config;

import java.util.Objects;
import java.util.Optional;
import tech.pegasys.teku.infrastructure.unsigned.UInt64;
import tech.pegasys.teku.ssz.type.Bytes4;

public class SpecConfigAltair extends DelegatingSpecConfig {
  // Updated penalties
  private final UInt64 inactivityPenaltyQuotientAltair;
  private final int minSlashingPenaltyQuotientAltair;
  private final int proportionalSlashingMultiplierAltair;

  // Misc
  private final int syncCommitteeSize;
  private final UInt64 inactivityScoreBias;
  private final UInt64 inactivityScoreRecoveryRate;

  // Time
  private final int epochsPerSyncCommitteePeriod;

  // Signature domains
  private final Bytes4 domainSyncCommittee;
  private final Bytes4 domainSyncCommitteeSelectionProof;
  private final Bytes4 domainContributionAndProof;

  // Fork
  private final Bytes4 altairForkVersion;
  private final UInt64 altairForkEpoch;

  // Sync protocol
  private final int minSyncCommitteeParticipants;

  // Validator
  private final int targetAggregatorsPerSyncSubcommittee;

  public SpecConfigAltair(
      final SpecConfig specConfig,
      final UInt64 inactivityPenaltyQuotientAltair,
      final int altairMinSlashingPenaltyQuotient,
      final int proportionalSlashingMultiplierAltair,
      final int syncCommitteeSize,
      final UInt64 inactivityScoreBias,
      final UInt64 inactivityScoreRecoveryRate,
      final int epochsPerSyncCommitteePeriod,
      final Bytes4 domainSyncCommittee,
      final Bytes4 domainSyncCommitteeSelectionProof,
      final Bytes4 domainContributionAndProof,
      final Bytes4 altairForkVersion,
      final UInt64 altairForkEpoch,
      final int minSyncCommitteeParticipants,
      final int targetAggregatorsPerSyncSubcommittee) {
    super(specConfig);
    this.inactivityPenaltyQuotientAltair = inactivityPenaltyQuotientAltair;
    this.minSlashingPenaltyQuotientAltair = altairMinSlashingPenaltyQuotient;
    this.proportionalSlashingMultiplierAltair = proportionalSlashingMultiplierAltair;
    this.syncCommitteeSize = syncCommitteeSize;
    this.inactivityScoreBias = inactivityScoreBias;
    this.inactivityScoreRecoveryRate = inactivityScoreRecoveryRate;
    this.epochsPerSyncCommitteePeriod = epochsPerSyncCommitteePeriod;
    this.domainSyncCommittee = domainSyncCommittee;
    this.domainSyncCommitteeSelectionProof = domainSyncCommitteeSelectionProof;
    this.domainContributionAndProof = domainContributionAndProof;
    this.altairForkVersion = altairForkVersion;
    this.altairForkEpoch = altairForkEpoch;
    this.minSyncCommitteeParticipants = minSyncCommitteeParticipants;
    this.targetAggregatorsPerSyncSubcommittee = targetAggregatorsPerSyncSubcommittee;
  }

  public static SpecConfigAltair required(final SpecConfig specConfig) {
    return specConfig
        .toVersionAltair()
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    "Expected altair spec config but got: "
                        + specConfig.getClass().getSimpleName()));
  }

  public Bytes4 getAltairForkVersion() {
    return altairForkVersion;
  }

  public UInt64 getAltairForkEpoch() {
    return altairForkEpoch;
  }

  public UInt64 getInactivityPenaltyQuotientAltair() {
    return inactivityPenaltyQuotientAltair;
  }

  public int getMinSlashingPenaltyQuotientAltair() {
    return minSlashingPenaltyQuotientAltair;
  }

  public int getProportionalSlashingMultiplierAltair() {
    return proportionalSlashingMultiplierAltair;
  }

  public int getSyncCommitteeSize() {
    return syncCommitteeSize;
  }

  public UInt64 getInactivityScoreBias() {
    return inactivityScoreBias;
  }

  public UInt64 getInactivityScoreRecoveryRate() {
    return inactivityScoreRecoveryRate;
  }

  public int getEpochsPerSyncCommitteePeriod() {
    return epochsPerSyncCommitteePeriod;
  }

  public Bytes4 getDomainSyncCommittee() {
    return domainSyncCommittee;
  }

  public Bytes4 getDomainSyncCommitteeSelectionProof() {
    return domainSyncCommitteeSelectionProof;
  }

  public Bytes4 getDomainContributionAndProof() {
    return domainContributionAndProof;
  }

  public int getTargetAggregatorsPerSyncSubcommittee() {
    return targetAggregatorsPerSyncSubcommittee;
  }

  @Override
  public Optional<SpecConfigAltair> toVersionAltair() {
    return Optional.of(this);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final SpecConfigAltair that = (SpecConfigAltair) o;
    return Objects.equals(specConfig, that.specConfig)
        && minSlashingPenaltyQuotientAltair == that.minSlashingPenaltyQuotientAltair
        && proportionalSlashingMultiplierAltair == that.proportionalSlashingMultiplierAltair
        && syncCommitteeSize == that.syncCommitteeSize
        && Objects.equals(inactivityScoreBias, that.inactivityScoreBias)
        && Objects.equals(inactivityScoreRecoveryRate, that.inactivityScoreRecoveryRate)
        && epochsPerSyncCommitteePeriod == that.epochsPerSyncCommitteePeriod
        && minSyncCommitteeParticipants == that.minSyncCommitteeParticipants
        && Objects.equals(inactivityPenaltyQuotientAltair, that.inactivityPenaltyQuotientAltair)
        && Objects.equals(domainSyncCommittee, that.domainSyncCommittee)
        && Objects.equals(domainSyncCommitteeSelectionProof, that.domainSyncCommitteeSelectionProof)
        && Objects.equals(domainContributionAndProof, that.domainContributionAndProof)
        && Objects.equals(altairForkVersion, that.altairForkVersion)
        && Objects.equals(altairForkEpoch, that.altairForkEpoch)
        && Objects.equals(
            targetAggregatorsPerSyncSubcommittee, that.targetAggregatorsPerSyncSubcommittee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        specConfig,
        inactivityPenaltyQuotientAltair,
        minSlashingPenaltyQuotientAltair,
        proportionalSlashingMultiplierAltair,
        syncCommitteeSize,
        inactivityScoreBias,
        inactivityScoreRecoveryRate,
        epochsPerSyncCommitteePeriod,
        domainSyncCommittee,
        domainSyncCommitteeSelectionProof,
        domainContributionAndProof,
        altairForkVersion,
        altairForkEpoch,
        minSyncCommitteeParticipants,
        targetAggregatorsPerSyncSubcommittee);
  }
}

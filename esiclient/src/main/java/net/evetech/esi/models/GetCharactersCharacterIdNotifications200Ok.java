/*
 * EVE Swagger Interface
 * An OpenAPI for EVE Online
 *
 * OpenAPI spec version: 1.12
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package net.evetech.esi.models;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import org.threeten.bp.OffsetDateTime;

/**
 * 200 ok object
 */
@ApiModel(description = "200 ok object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-08-07T21:44:42.543-04:00")
public class GetCharactersCharacterIdNotifications200Ok {
  @SerializedName("is_read")
  private Boolean isRead = null;

  @SerializedName("notification_id")
  private Long notificationId = null;

  @SerializedName("sender_id")
  private Integer senderId = null;

  /**
   * sender_type string
   */
  @JsonAdapter(SenderTypeEnum.Adapter.class)
  public enum SenderTypeEnum {
    CHARACTER("character"),
    
    CORPORATION("corporation"),
    
    ALLIANCE("alliance"),
    
    FACTION("faction"),
    
    OTHER("other");

    private String value;

    SenderTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static SenderTypeEnum fromValue(String text) {
      for (SenderTypeEnum b : SenderTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<SenderTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final SenderTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public SenderTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return SenderTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("sender_type")
  private SenderTypeEnum senderType = null;

  @SerializedName("text")
  private String text = null;

  @SerializedName("timestamp")
  private OffsetDateTime timestamp = null;

  /**
   * type string
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    ACCEPTEDALLY("AcceptedAlly"),
    
    ACCEPTEDSURRENDER("AcceptedSurrender"),
    
    AGENTRETIREDTRIGRAVIAN("AgentRetiredTrigravian"),
    
    ALLANCHORINGMSG("AllAnchoringMsg"),
    
    ALLMAINTENANCEBILLMSG("AllMaintenanceBillMsg"),
    
    ALLSTRUCINVULNERABLEMSG("AllStrucInvulnerableMsg"),
    
    ALLSTRUCTVULNERABLEMSG("AllStructVulnerableMsg"),
    
    ALLWARCORPJOINEDALLIANCEMSG("AllWarCorpJoinedAllianceMsg"),
    
    ALLWARDECLAREDMSG("AllWarDeclaredMsg"),
    
    ALLWARINVALIDATEDMSG("AllWarInvalidatedMsg"),
    
    ALLWARRETRACTEDMSG("AllWarRetractedMsg"),
    
    ALLWARSURRENDERMSG("AllWarSurrenderMsg"),
    
    ALLIANCECAPITALCHANGED("AllianceCapitalChanged"),
    
    ALLIANCEWARDECLAREDV2("AllianceWarDeclaredV2"),
    
    ALLYCONTRACTCANCELLED("AllyContractCancelled"),
    
    ALLYJOINEDWARAGGRESSORMSG("AllyJoinedWarAggressorMsg"),
    
    ALLYJOINEDWARALLYMSG("AllyJoinedWarAllyMsg"),
    
    ALLYJOINEDWARDEFENDERMSG("AllyJoinedWarDefenderMsg"),
    
    BATTLEPUNISHFRIENDLYFIRE("BattlePunishFriendlyFire"),
    
    BILLOUTOFMONEYMSG("BillOutOfMoneyMsg"),
    
    BILLPAIDCORPALLMSG("BillPaidCorpAllMsg"),
    
    BOUNTYCLAIMMSG("BountyClaimMsg"),
    
    BOUNTYESSSHARED("BountyESSShared"),
    
    BOUNTYESSTAKEN("BountyESSTaken"),
    
    BOUNTYPLACEDALLIANCE("BountyPlacedAlliance"),
    
    BOUNTYPLACEDCHAR("BountyPlacedChar"),
    
    BOUNTYPLACEDCORP("BountyPlacedCorp"),
    
    BOUNTYYOURBOUNTYCLAIMED("BountyYourBountyClaimed"),
    
    BUDDYCONNECTCONTACTADD("BuddyConnectContactAdd"),
    
    CHARAPPACCEPTMSG("CharAppAcceptMsg"),
    
    CHARAPPREJECTMSG("CharAppRejectMsg"),
    
    CHARAPPWITHDRAWMSG("CharAppWithdrawMsg"),
    
    CHARLEFTCORPMSG("CharLeftCorpMsg"),
    
    CHARMEDALMSG("CharMedalMsg"),
    
    CHARTERMINATIONMSG("CharTerminationMsg"),
    
    CLONEACTIVATIONMSG("CloneActivationMsg"),
    
    CLONEACTIVATIONMSG2("CloneActivationMsg2"),
    
    CLONEMOVEDMSG("CloneMovedMsg"),
    
    CLONEREVOKEDMSG1("CloneRevokedMsg1"),
    
    CLONEREVOKEDMSG2("CloneRevokedMsg2"),
    
    COMBATOPERATIONFINISHED("CombatOperationFinished"),
    
    CONTACTADD("ContactAdd"),
    
    CONTACTEDIT("ContactEdit"),
    
    CONTAINERPASSWORDMSG("ContainerPasswordMsg"),
    
    CONTRACTREGIONCHANGEDTOPOCHVEN("ContractRegionChangedToPochven"),
    
    CORPALLBILLMSG("CorpAllBillMsg"),
    
    CORPAPPACCEPTMSG("CorpAppAcceptMsg"),
    
    CORPAPPINVITEDMSG("CorpAppInvitedMsg"),
    
    CORPAPPNEWMSG("CorpAppNewMsg"),
    
    CORPAPPREJECTCUSTOMMSG("CorpAppRejectCustomMsg"),
    
    CORPAPPREJECTMSG("CorpAppRejectMsg"),
    
    CORPBECAMEWARELIGIBLE("CorpBecameWarEligible"),
    
    CORPDIVIDENDMSG("CorpDividendMsg"),
    
    CORPFRIENDLYFIREDISABLETIMERCOMPLETED("CorpFriendlyFireDisableTimerCompleted"),
    
    CORPFRIENDLYFIREDISABLETIMERSTARTED("CorpFriendlyFireDisableTimerStarted"),
    
    CORPFRIENDLYFIREENABLETIMERCOMPLETED("CorpFriendlyFireEnableTimerCompleted"),
    
    CORPFRIENDLYFIREENABLETIMERSTARTED("CorpFriendlyFireEnableTimerStarted"),
    
    CORPKICKED("CorpKicked"),
    
    CORPLIQUIDATIONMSG("CorpLiquidationMsg"),
    
    CORPNEWCEOMSG("CorpNewCEOMsg"),
    
    CORPNEWSMSG("CorpNewsMsg"),
    
    CORPNOLONGERWARELIGIBLE("CorpNoLongerWarEligible"),
    
    CORPOFFICEEXPIRATIONMSG("CorpOfficeExpirationMsg"),
    
    CORPSTRUCTLOSTMSG("CorpStructLostMsg"),
    
    CORPTAXCHANGEMSG("CorpTaxChangeMsg"),
    
    CORPVOTECEOREVOKEDMSG("CorpVoteCEORevokedMsg"),
    
    CORPVOTEMSG("CorpVoteMsg"),
    
    CORPWARDECLAREDMSG("CorpWarDeclaredMsg"),
    
    CORPWARDECLAREDV2("CorpWarDeclaredV2"),
    
    CORPWARFIGHTINGLEGALMSG("CorpWarFightingLegalMsg"),
    
    CORPWARINVALIDATEDMSG("CorpWarInvalidatedMsg"),
    
    CORPWARRETRACTEDMSG("CorpWarRetractedMsg"),
    
    CORPWARSURRENDERMSG("CorpWarSurrenderMsg"),
    
    CUSTOMSMSG("CustomsMsg"),
    
    DECLAREWAR("DeclareWar"),
    
    DISTRICTATTACKED("DistrictAttacked"),
    
    DUSTAPPACCEPTEDMSG("DustAppAcceptedMsg"),
    
    ESSMAINBANKLINK("ESSMainBankLink"),
    
    ENTOSISCAPTURESTARTED("EntosisCaptureStarted"),
    
    EXPERTSYSTEMEXPIRED("ExpertSystemExpired"),
    
    EXPERTSYSTEMEXPIRYIMMINENT("ExpertSystemExpiryImminent"),
    
    FWALLIANCEKICKMSG("FWAllianceKickMsg"),
    
    FWALLIANCEWARNINGMSG("FWAllianceWarningMsg"),
    
    FWCHARKICKMSG("FWCharKickMsg"),
    
    FWCHARRANKGAINMSG("FWCharRankGainMsg"),
    
    FWCHARRANKLOSSMSG("FWCharRankLossMsg"),
    
    FWCHARWARNINGMSG("FWCharWarningMsg"),
    
    FWCORPJOINMSG("FWCorpJoinMsg"),
    
    FWCORPKICKMSG("FWCorpKickMsg"),
    
    FWCORPLEAVEMSG("FWCorpLeaveMsg"),
    
    FWCORPWARNINGMSG("FWCorpWarningMsg"),
    
    FACWARCORPJOINREQUESTMSG("FacWarCorpJoinRequestMsg"),
    
    FACWARCORPJOINWITHDRAWMSG("FacWarCorpJoinWithdrawMsg"),
    
    FACWARCORPLEAVEREQUESTMSG("FacWarCorpLeaveRequestMsg"),
    
    FACWARCORPLEAVEWITHDRAWMSG("FacWarCorpLeaveWithdrawMsg"),
    
    FACWARLPDISQUALIFIEDEVENT("FacWarLPDisqualifiedEvent"),
    
    FACWARLPDISQUALIFIEDKILL("FacWarLPDisqualifiedKill"),
    
    FACWARLPPAYOUTEVENT("FacWarLPPayoutEvent"),
    
    FACWARLPPAYOUTKILL("FacWarLPPayoutKill"),
    
    GAMETIMEADDED("GameTimeAdded"),
    
    GAMETIMERECEIVED("GameTimeReceived"),
    
    GAMETIMESENT("GameTimeSent"),
    
    GIFTRECEIVED("GiftReceived"),
    
    IHUBDESTROYEDBYBILLFAILURE("IHubDestroyedByBillFailure"),
    
    INCURSIONCOMPLETEDMSG("IncursionCompletedMsg"),
    
    INDUSTRYOPERATIONFINISHED("IndustryOperationFinished"),
    
    INDUSTRYTEAMAUCTIONLOST("IndustryTeamAuctionLost"),
    
    INDUSTRYTEAMAUCTIONWON("IndustryTeamAuctionWon"),
    
    INFRASTRUCTUREHUBBILLABOUTTOEXPIRE("InfrastructureHubBillAboutToExpire"),
    
    INSURANCEEXPIRATIONMSG("InsuranceExpirationMsg"),
    
    INSURANCEFIRSTSHIPMSG("InsuranceFirstShipMsg"),
    
    INSURANCEINVALIDATEDMSG("InsuranceInvalidatedMsg"),
    
    INSURANCEISSUEDMSG("InsuranceIssuedMsg"),
    
    INSURANCEPAYOUTMSG("InsurancePayoutMsg"),
    
    INVASIONCOMPLETEDMSG("InvasionCompletedMsg"),
    
    INVASIONSYSTEMLOGIN("InvasionSystemLogin"),
    
    INVASIONSYSTEMSTART("InvasionSystemStart"),
    
    JUMPCLONEDELETEDMSG1("JumpCloneDeletedMsg1"),
    
    JUMPCLONEDELETEDMSG2("JumpCloneDeletedMsg2"),
    
    KILLREPORTFINALBLOW("KillReportFinalBlow"),
    
    KILLREPORTVICTIM("KillReportVictim"),
    
    KILLRIGHTAVAILABLE("KillRightAvailable"),
    
    KILLRIGHTAVAILABLEOPEN("KillRightAvailableOpen"),
    
    KILLRIGHTEARNED("KillRightEarned"),
    
    KILLRIGHTUNAVAILABLE("KillRightUnavailable"),
    
    KILLRIGHTUNAVAILABLEOPEN("KillRightUnavailableOpen"),
    
    KILLRIGHTUSED("KillRightUsed"),
    
    LOCATECHARMSG("LocateCharMsg"),
    
    MADEWARMUTUAL("MadeWarMutual"),
    
    MERCOFFERRETRACTEDMSG("MercOfferRetractedMsg"),
    
    MERCOFFEREDNEGOTIATIONMSG("MercOfferedNegotiationMsg"),
    
    MISSIONCANCELEDTRIGLAVIAN("MissionCanceledTriglavian"),
    
    MISSIONOFFEREXPIRATIONMSG("MissionOfferExpirationMsg"),
    
    MISSIONTIMEOUTMSG("MissionTimeoutMsg"),
    
    MOONMININGAUTOMATICFRACTURE("MoonminingAutomaticFracture"),
    
    MOONMININGEXTRACTIONCANCELLED("MoonminingExtractionCancelled"),
    
    MOONMININGEXTRACTIONFINISHED("MoonminingExtractionFinished"),
    
    MOONMININGEXTRACTIONSTARTED("MoonminingExtractionStarted"),
    
    MOONMININGLASERFIRED("MoonminingLaserFired"),
    
    MUTUALWAREXPIRED("MutualWarExpired"),
    
    MUTUALWARINVITEACCEPTED("MutualWarInviteAccepted"),
    
    MUTUALWARINVITEREJECTED("MutualWarInviteRejected"),
    
    MUTUALWARINVITESENT("MutualWarInviteSent"),
    
    NPCSTANDINGSGAINED("NPCStandingsGained"),
    
    NPCSTANDINGSLOST("NPCStandingsLost"),
    
    OFFERTOALLYRETRACTED("OfferToAllyRetracted"),
    
    OFFEREDSURRENDER("OfferedSurrender"),
    
    OFFEREDTOALLY("OfferedToAlly"),
    
    OFFICELEASECANCELEDINSUFFICIENTSTANDINGS("OfficeLeaseCanceledInsufficientStandings"),
    
    OLDLSCMESSAGES("OldLscMessages"),
    
    OPERATIONFINISHED("OperationFinished"),
    
    ORBITALATTACKED("OrbitalAttacked"),
    
    ORBITALREINFORCED("OrbitalReinforced"),
    
    OWNERSHIPTRANSFERRED("OwnershipTransferred"),
    
    RAFFLECREATED("RaffleCreated"),
    
    RAFFLEEXPIRED("RaffleExpired"),
    
    RAFFLEFINISHED("RaffleFinished"),
    
    REIMBURSEMENTMSG("ReimbursementMsg"),
    
    RESEARCHMISSIONAVAILABLEMSG("ResearchMissionAvailableMsg"),
    
    RETRACTSWAR("RetractsWar"),
    
    SEASONALCHALLENGECOMPLETED("SeasonalChallengeCompleted"),
    
    SOVALLCLAIMAQUIREDMSG("SovAllClaimAquiredMsg"),
    
    SOVALLCLAIMLOSTMSG("SovAllClaimLostMsg"),
    
    SOVCOMMANDNODEEVENTSTARTED("SovCommandNodeEventStarted"),
    
    SOVCORPBILLLATEMSG("SovCorpBillLateMsg"),
    
    SOVCORPCLAIMFAILMSG("SovCorpClaimFailMsg"),
    
    SOVDISRUPTORMSG("SovDisruptorMsg"),
    
    SOVSTATIONENTEREDFREEPORT("SovStationEnteredFreeport"),
    
    SOVSTRUCTUREDESTROYED("SovStructureDestroyed"),
    
    SOVSTRUCTUREREINFORCED("SovStructureReinforced"),
    
    SOVSTRUCTURESELFDESTRUCTCANCEL("SovStructureSelfDestructCancel"),
    
    SOVSTRUCTURESELFDESTRUCTFINISHED("SovStructureSelfDestructFinished"),
    
    SOVSTRUCTURESELFDESTRUCTREQUESTED("SovStructureSelfDestructRequested"),
    
    SOVEREIGNTYIHDAMAGEMSG("SovereigntyIHDamageMsg"),
    
    SOVEREIGNTYSBUDAMAGEMSG("SovereigntySBUDamageMsg"),
    
    SOVEREIGNTYTCUDAMAGEMSG("SovereigntyTCUDamageMsg"),
    
    STATIONAGGRESSIONMSG1("StationAggressionMsg1"),
    
    STATIONAGGRESSIONMSG2("StationAggressionMsg2"),
    
    STATIONCONQUERMSG("StationConquerMsg"),
    
    STATIONSERVICEDISABLED("StationServiceDisabled"),
    
    STATIONSERVICEENABLED("StationServiceEnabled"),
    
    STATIONSTATECHANGEMSG("StationStateChangeMsg"),
    
    STORYLINEMISSIONAVAILABLEMSG("StoryLineMissionAvailableMsg"),
    
    STRUCTUREANCHORING("StructureAnchoring"),
    
    STRUCTURECOURIERCONTRACTCHANGED("StructureCourierContractChanged"),
    
    STRUCTUREDESTROYED("StructureDestroyed"),
    
    STRUCTUREFUELALERT("StructureFuelAlert"),
    
    STRUCTUREIMPENDINGABANDONMENTASSETSATRISK("StructureImpendingAbandonmentAssetsAtRisk"),
    
    STRUCTUREITEMSDELIVERED("StructureItemsDelivered"),
    
    STRUCTUREITEMSMOVEDTOSAFETY("StructureItemsMovedToSafety"),
    
    STRUCTURELOSTARMOR("StructureLostArmor"),
    
    STRUCTURELOSTSHIELDS("StructureLostShields"),
    
    STRUCTUREONLINE("StructureOnline"),
    
    STRUCTURESERVICESOFFLINE("StructureServicesOffline"),
    
    STRUCTUREUNANCHORING("StructureUnanchoring"),
    
    STRUCTUREUNDERATTACK("StructureUnderAttack"),
    
    STRUCTUREWENTHIGHPOWER("StructureWentHighPower"),
    
    STRUCTUREWENTLOWPOWER("StructureWentLowPower"),
    
    STRUCTURESJOBSCANCELLED("StructuresJobsCancelled"),
    
    STRUCTURESJOBSPAUSED("StructuresJobsPaused"),
    
    STRUCTURESREINFORCEMENTCHANGED("StructuresReinforcementChanged"),
    
    TOWERALERTMSG("TowerAlertMsg"),
    
    TOWERRESOURCEALERTMSG("TowerResourceAlertMsg"),
    
    TRANSACTIONREVERSALMSG("TransactionReversalMsg"),
    
    TUTORIALMSG("TutorialMsg"),
    
    WARADOPTED_("WarAdopted "),
    
    WARALLYINHERITED("WarAllyInherited"),
    
    WARALLYOFFERDECLINEDMSG("WarAllyOfferDeclinedMsg"),
    
    WARCONCORDINVALIDATES("WarConcordInvalidates"),
    
    WARDECLARED("WarDeclared"),
    
    WARENDEDHQSECURITYDROP("WarEndedHqSecurityDrop"),
    
    WARHQREMOVEDFROMSPACE("WarHQRemovedFromSpace"),
    
    WARINHERITED("WarInherited"),
    
    WARINVALID("WarInvalid"),
    
    WARRETRACTED("WarRetracted"),
    
    WARRETRACTEDBYCONCORD("WarRetractedByConcord"),
    
    WARSURRENDERDECLINEDMSG("WarSurrenderDeclinedMsg"),
    
    WARSURRENDEROFFERMSG("WarSurrenderOfferMsg");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("type")
  private TypeEnum type = null;

  public GetCharactersCharacterIdNotifications200Ok isRead(Boolean isRead) {
    this.isRead = isRead;
    return this;
  }

   /**
   * is_read boolean
   * @return isRead
  **/
  @ApiModelProperty(value = "is_read boolean")
  public Boolean isIsRead() {
    return isRead;
  }

  public void setIsRead(Boolean isRead) {
    this.isRead = isRead;
  }

  public GetCharactersCharacterIdNotifications200Ok notificationId(Long notificationId) {
    this.notificationId = notificationId;
    return this;
  }

   /**
   * notification_id integer
   * @return notificationId
  **/
  @ApiModelProperty(required = true, value = "notification_id integer")
  public Long getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(Long notificationId) {
    this.notificationId = notificationId;
  }

  public GetCharactersCharacterIdNotifications200Ok senderId(Integer senderId) {
    this.senderId = senderId;
    return this;
  }

   /**
   * sender_id integer
   * @return senderId
  **/
  @ApiModelProperty(required = true, value = "sender_id integer")
  public Integer getSenderId() {
    return senderId;
  }

  public void setSenderId(Integer senderId) {
    this.senderId = senderId;
  }

  public GetCharactersCharacterIdNotifications200Ok senderType(SenderTypeEnum senderType) {
    this.senderType = senderType;
    return this;
  }

   /**
   * sender_type string
   * @return senderType
  **/
  @ApiModelProperty(required = true, value = "sender_type string")
  public SenderTypeEnum getSenderType() {
    return senderType;
  }

  public void setSenderType(SenderTypeEnum senderType) {
    this.senderType = senderType;
  }

  public GetCharactersCharacterIdNotifications200Ok text(String text) {
    this.text = text;
    return this;
  }

   /**
   * text string
   * @return text
  **/
  @ApiModelProperty(value = "text string")
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public GetCharactersCharacterIdNotifications200Ok timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * timestamp string
   * @return timestamp
  **/
  @ApiModelProperty(required = true, value = "timestamp string")
  public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public GetCharactersCharacterIdNotifications200Ok type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * type string
   * @return type
  **/
  @ApiModelProperty(required = true, value = "type string")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCharactersCharacterIdNotifications200Ok getCharactersCharacterIdNotifications200Ok = (GetCharactersCharacterIdNotifications200Ok) o;
    return Objects.equals(this.isRead, getCharactersCharacterIdNotifications200Ok.isRead) &&
        Objects.equals(this.notificationId, getCharactersCharacterIdNotifications200Ok.notificationId) &&
        Objects.equals(this.senderId, getCharactersCharacterIdNotifications200Ok.senderId) &&
        Objects.equals(this.senderType, getCharactersCharacterIdNotifications200Ok.senderType) &&
        Objects.equals(this.text, getCharactersCharacterIdNotifications200Ok.text) &&
        Objects.equals(this.timestamp, getCharactersCharacterIdNotifications200Ok.timestamp) &&
        Objects.equals(this.type, getCharactersCharacterIdNotifications200Ok.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isRead, notificationId, senderId, senderType, text, timestamp, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCharactersCharacterIdNotifications200Ok {\n");
    
    sb.append("    isRead: ").append(toIndentedString(isRead)).append("\n");
    sb.append("    notificationId: ").append(toIndentedString(notificationId)).append("\n");
    sb.append("    senderId: ").append(toIndentedString(senderId)).append("\n");
    sb.append("    senderType: ").append(toIndentedString(senderType)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


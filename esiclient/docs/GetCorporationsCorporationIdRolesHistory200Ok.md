
# GetCorporationsCorporationIdRolesHistory200Ok

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**changedAt** | [**OffsetDateTime**](OffsetDateTime.md) | changed_at string | 
**characterId** | **Integer** | The character whose roles are changed | 
**issuerId** | **Integer** | ID of the character who issued this change | 
**newRoles** | [**List&lt;NewRolesEnum&gt;**](#List&lt;NewRolesEnum&gt;) | new_roles array | 
**oldRoles** | [**List&lt;OldRolesEnum&gt;**](#List&lt;OldRolesEnum&gt;) | old_roles array | 
**roleType** | [**RoleTypeEnum**](#RoleTypeEnum) | role_type string | 


<a name="List<NewRolesEnum>"></a>
## Enum: List&lt;NewRolesEnum&gt;
Name | Value
---- | -----
ACCOUNT_TAKE_1 | &quot;Account_Take_1&quot;
ACCOUNT_TAKE_2 | &quot;Account_Take_2&quot;
ACCOUNT_TAKE_3 | &quot;Account_Take_3&quot;
ACCOUNT_TAKE_4 | &quot;Account_Take_4&quot;
ACCOUNT_TAKE_5 | &quot;Account_Take_5&quot;
ACCOUNT_TAKE_6 | &quot;Account_Take_6&quot;
ACCOUNT_TAKE_7 | &quot;Account_Take_7&quot;
ACCOUNTANT | &quot;Accountant&quot;
AUDITOR | &quot;Auditor&quot;
COMMUNICATIONS_OFFICER | &quot;Communications_Officer&quot;
CONFIG_EQUIPMENT | &quot;Config_Equipment&quot;
CONFIG_STARBASE_EQUIPMENT | &quot;Config_Starbase_Equipment&quot;
CONTAINER_TAKE_1 | &quot;Container_Take_1&quot;
CONTAINER_TAKE_2 | &quot;Container_Take_2&quot;
CONTAINER_TAKE_3 | &quot;Container_Take_3&quot;
CONTAINER_TAKE_4 | &quot;Container_Take_4&quot;
CONTAINER_TAKE_5 | &quot;Container_Take_5&quot;
CONTAINER_TAKE_6 | &quot;Container_Take_6&quot;
CONTAINER_TAKE_7 | &quot;Container_Take_7&quot;
CONTRACT_MANAGER | &quot;Contract_Manager&quot;
DIPLOMAT | &quot;Diplomat&quot;
DIRECTOR | &quot;Director&quot;
FACTORY_MANAGER | &quot;Factory_Manager&quot;
FITTING_MANAGER | &quot;Fitting_Manager&quot;
HANGAR_QUERY_1 | &quot;Hangar_Query_1&quot;
HANGAR_QUERY_2 | &quot;Hangar_Query_2&quot;
HANGAR_QUERY_3 | &quot;Hangar_Query_3&quot;
HANGAR_QUERY_4 | &quot;Hangar_Query_4&quot;
HANGAR_QUERY_5 | &quot;Hangar_Query_5&quot;
HANGAR_QUERY_6 | &quot;Hangar_Query_6&quot;
HANGAR_QUERY_7 | &quot;Hangar_Query_7&quot;
HANGAR_TAKE_1 | &quot;Hangar_Take_1&quot;
HANGAR_TAKE_2 | &quot;Hangar_Take_2&quot;
HANGAR_TAKE_3 | &quot;Hangar_Take_3&quot;
HANGAR_TAKE_4 | &quot;Hangar_Take_4&quot;
HANGAR_TAKE_5 | &quot;Hangar_Take_5&quot;
HANGAR_TAKE_6 | &quot;Hangar_Take_6&quot;
HANGAR_TAKE_7 | &quot;Hangar_Take_7&quot;
JUNIOR_ACCOUNTANT | &quot;Junior_Accountant&quot;
PERSONNEL_MANAGER | &quot;Personnel_Manager&quot;
RENT_FACTORY_FACILITY | &quot;Rent_Factory_Facility&quot;
RENT_OFFICE | &quot;Rent_Office&quot;
RENT_RESEARCH_FACILITY | &quot;Rent_Research_Facility&quot;
SECURITY_OFFICER | &quot;Security_Officer&quot;
STARBASE_DEFENSE_OPERATOR | &quot;Starbase_Defense_Operator&quot;
STARBASE_FUEL_TECHNICIAN | &quot;Starbase_Fuel_Technician&quot;
STATION_MANAGER | &quot;Station_Manager&quot;
TRADER | &quot;Trader&quot;


<a name="List<OldRolesEnum>"></a>
## Enum: List&lt;OldRolesEnum&gt;
Name | Value
---- | -----
ACCOUNT_TAKE_1 | &quot;Account_Take_1&quot;
ACCOUNT_TAKE_2 | &quot;Account_Take_2&quot;
ACCOUNT_TAKE_3 | &quot;Account_Take_3&quot;
ACCOUNT_TAKE_4 | &quot;Account_Take_4&quot;
ACCOUNT_TAKE_5 | &quot;Account_Take_5&quot;
ACCOUNT_TAKE_6 | &quot;Account_Take_6&quot;
ACCOUNT_TAKE_7 | &quot;Account_Take_7&quot;
ACCOUNTANT | &quot;Accountant&quot;
AUDITOR | &quot;Auditor&quot;
COMMUNICATIONS_OFFICER | &quot;Communications_Officer&quot;
CONFIG_EQUIPMENT | &quot;Config_Equipment&quot;
CONFIG_STARBASE_EQUIPMENT | &quot;Config_Starbase_Equipment&quot;
CONTAINER_TAKE_1 | &quot;Container_Take_1&quot;
CONTAINER_TAKE_2 | &quot;Container_Take_2&quot;
CONTAINER_TAKE_3 | &quot;Container_Take_3&quot;
CONTAINER_TAKE_4 | &quot;Container_Take_4&quot;
CONTAINER_TAKE_5 | &quot;Container_Take_5&quot;
CONTAINER_TAKE_6 | &quot;Container_Take_6&quot;
CONTAINER_TAKE_7 | &quot;Container_Take_7&quot;
CONTRACT_MANAGER | &quot;Contract_Manager&quot;
DIPLOMAT | &quot;Diplomat&quot;
DIRECTOR | &quot;Director&quot;
FACTORY_MANAGER | &quot;Factory_Manager&quot;
FITTING_MANAGER | &quot;Fitting_Manager&quot;
HANGAR_QUERY_1 | &quot;Hangar_Query_1&quot;
HANGAR_QUERY_2 | &quot;Hangar_Query_2&quot;
HANGAR_QUERY_3 | &quot;Hangar_Query_3&quot;
HANGAR_QUERY_4 | &quot;Hangar_Query_4&quot;
HANGAR_QUERY_5 | &quot;Hangar_Query_5&quot;
HANGAR_QUERY_6 | &quot;Hangar_Query_6&quot;
HANGAR_QUERY_7 | &quot;Hangar_Query_7&quot;
HANGAR_TAKE_1 | &quot;Hangar_Take_1&quot;
HANGAR_TAKE_2 | &quot;Hangar_Take_2&quot;
HANGAR_TAKE_3 | &quot;Hangar_Take_3&quot;
HANGAR_TAKE_4 | &quot;Hangar_Take_4&quot;
HANGAR_TAKE_5 | &quot;Hangar_Take_5&quot;
HANGAR_TAKE_6 | &quot;Hangar_Take_6&quot;
HANGAR_TAKE_7 | &quot;Hangar_Take_7&quot;
JUNIOR_ACCOUNTANT | &quot;Junior_Accountant&quot;
PERSONNEL_MANAGER | &quot;Personnel_Manager&quot;
RENT_FACTORY_FACILITY | &quot;Rent_Factory_Facility&quot;
RENT_OFFICE | &quot;Rent_Office&quot;
RENT_RESEARCH_FACILITY | &quot;Rent_Research_Facility&quot;
SECURITY_OFFICER | &quot;Security_Officer&quot;
STARBASE_DEFENSE_OPERATOR | &quot;Starbase_Defense_Operator&quot;
STARBASE_FUEL_TECHNICIAN | &quot;Starbase_Fuel_Technician&quot;
STATION_MANAGER | &quot;Station_Manager&quot;
TRADER | &quot;Trader&quot;


<a name="RoleTypeEnum"></a>
## Enum: RoleTypeEnum
Name | Value
---- | -----
GRANTABLE_ROLES | &quot;grantable_roles&quot;
GRANTABLE_ROLES_AT_BASE | &quot;grantable_roles_at_base&quot;
GRANTABLE_ROLES_AT_HQ | &quot;grantable_roles_at_hq&quot;
GRANTABLE_ROLES_AT_OTHER | &quot;grantable_roles_at_other&quot;
ROLES | &quot;roles&quot;
ROLES_AT_BASE | &quot;roles_at_base&quot;
ROLES_AT_HQ | &quot;roles_at_hq&quot;
ROLES_AT_OTHER | &quot;roles_at_other&quot;




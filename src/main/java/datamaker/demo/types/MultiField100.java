package datamaker.demo.types;

import com.github.javafaker.Faker;

import datamaker.DataMaker;
import datamaker.annotations.SelfCollection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MultiField100 {

    public MultiField100() {
        super();
    }

    public static Faker faker() {
        return DataMaker.faker();
    }

    ObservableList<MultiField100> children = FXCollections.observableArrayList();

    // @Override
    @SelfCollection(minSize = 1, maxSize = 1, minDepth = 1, maxDepth = 1)
    public ObservableList<MultiField100> getChildren() {
        return this.children;
    }

    private final SimpleStringProperty field0 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field1 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field2 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field3 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field4 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field5 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field6 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field7 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field8 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field9 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field10 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field11 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field12 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field13 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field14 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field15 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field16 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field17 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field18 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field19 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field20 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field21 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field22 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field23 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field24 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field25 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field26 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field27 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field28 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field29 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field30 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field31 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field32 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field33 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field34 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field35 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field36 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field37 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field38 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field39 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field40 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field41 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field42 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field43 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field44 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field45 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field46 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field47 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field48 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field49 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field50 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field51 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field52 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field53 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field54 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field55 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field56 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field57 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field58 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field59 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field60 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field61 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field62 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field63 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field64 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field65 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field66 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field67 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field68 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field69 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field70 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field71 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field72 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field73 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field74 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field75 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field76 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field77 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field78 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field79 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field80 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field81 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field82 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field83 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field84 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field85 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field86 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field87 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field88 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field89 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field90 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field91 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field92 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field93 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field94 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field95 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field96 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field97 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field98 = new SimpleStringProperty(faker().name().firstName());
    private final SimpleStringProperty field99 = new SimpleStringProperty(faker().name().firstName());
    public final SimpleStringProperty field0Property() {
        return this.field0;
    }

    public final String getField0() {
        return this.field0Property().get();
    }

    public final void setField0(final String field0) {
        this.field0Property().set(field0);
    }

    public final SimpleStringProperty field1Property() {
        return this.field1;
    }

    public final String getField1() {
        return this.field1Property().get();
    }

    public final void setField1(final String field1) {
        this.field1Property().set(field1);
    }

    public final SimpleStringProperty field2Property() {
        return this.field2;
    }

    public final String getField2() {
        return this.field2Property().get();
    }

    public final void setField2(final String field2) {
        this.field2Property().set(field2);
    }

    public final SimpleStringProperty field3Property() {
        return this.field3;
    }

    public final String getField3() {
        return this.field3Property().get();
    }

    public final void setField3(final String field3) {
        this.field3Property().set(field3);
    }

    public final SimpleStringProperty field4Property() {
        return this.field4;
    }

    public final String getField4() {
        return this.field4Property().get();
    }

    public final void setField4(final String field4) {
        this.field4Property().set(field4);
    }

    public final SimpleStringProperty field5Property() {
        return this.field5;
    }

    public final String getField5() {
        return this.field5Property().get();
    }

    public final void setField5(final String field5) {
        this.field5Property().set(field5);
    }

    public final SimpleStringProperty field6Property() {
        return this.field6;
    }

    public final String getField6() {
        return this.field6Property().get();
    }

    public final void setField6(final String field6) {
        this.field6Property().set(field6);
    }

    public final SimpleStringProperty field7Property() {
        return this.field7;
    }

    public final String getField7() {
        return this.field7Property().get();
    }

    public final void setField7(final String field7) {
        this.field7Property().set(field7);
    }

    public final SimpleStringProperty field8Property() {
        return this.field8;
    }

    public final String getField8() {
        return this.field8Property().get();
    }

    public final void setField8(final String field8) {
        this.field8Property().set(field8);
    }

    public final SimpleStringProperty field9Property() {
        return this.field9;
    }

    public final String getField9() {
        return this.field9Property().get();
    }

    public final void setField9(final String field9) {
        this.field9Property().set(field9);
    }

    public final SimpleStringProperty field10Property() {
        return this.field10;
    }

    public final String getField10() {
        return this.field10Property().get();
    }

    public final void setField10(final String field10) {
        this.field10Property().set(field10);
    }

    public final SimpleStringProperty field11Property() {
        return this.field11;
    }

    public final String getField11() {
        return this.field11Property().get();
    }

    public final void setField11(final String field11) {
        this.field11Property().set(field11);
    }

    public final SimpleStringProperty field12Property() {
        return this.field12;
    }

    public final String getField12() {
        return this.field12Property().get();
    }

    public final void setField12(final String field12) {
        this.field12Property().set(field12);
    }

    public final SimpleStringProperty field13Property() {
        return this.field13;
    }

    public final String getField13() {
        return this.field13Property().get();
    }

    public final void setField13(final String field13) {
        this.field13Property().set(field13);
    }

    public final SimpleStringProperty field14Property() {
        return this.field14;
    }

    public final String getField14() {
        return this.field14Property().get();
    }

    public final void setField14(final String field14) {
        this.field14Property().set(field14);
    }

    public final SimpleStringProperty field15Property() {
        return this.field15;
    }

    public final String getField15() {
        return this.field15Property().get();
    }

    public final void setField15(final String field15) {
        this.field15Property().set(field15);
    }

    public final SimpleStringProperty field16Property() {
        return this.field16;
    }

    public final String getField16() {
        return this.field16Property().get();
    }

    public final void setField16(final String field16) {
        this.field16Property().set(field16);
    }

    public final SimpleStringProperty field17Property() {
        return this.field17;
    }

    public final String getField17() {
        return this.field17Property().get();
    }

    public final void setField17(final String field17) {
        this.field17Property().set(field17);
    }

    public final SimpleStringProperty field18Property() {
        return this.field18;
    }

    public final String getField18() {
        return this.field18Property().get();
    }

    public final void setField18(final String field18) {
        this.field18Property().set(field18);
    }

    public final SimpleStringProperty field19Property() {
        return this.field19;
    }

    public final String getField19() {
        return this.field19Property().get();
    }

    public final void setField19(final String field19) {
        this.field19Property().set(field19);
    }

    public final SimpleStringProperty field20Property() {
        return this.field20;
    }

    public final String getField20() {
        return this.field20Property().get();
    }

    public final void setField20(final String field20) {
        this.field20Property().set(field20);
    }

    public final SimpleStringProperty field21Property() {
        return this.field21;
    }

    public final String getField21() {
        return this.field21Property().get();
    }

    public final void setField21(final String field21) {
        this.field21Property().set(field21);
    }

    public final SimpleStringProperty field22Property() {
        return this.field22;
    }

    public final String getField22() {
        return this.field22Property().get();
    }

    public final void setField22(final String field22) {
        this.field22Property().set(field22);
    }

    public final SimpleStringProperty field23Property() {
        return this.field23;
    }

    public final String getField23() {
        return this.field23Property().get();
    }

    public final void setField23(final String field23) {
        this.field23Property().set(field23);
    }

    public final SimpleStringProperty field24Property() {
        return this.field24;
    }

    public final String getField24() {
        return this.field24Property().get();
    }

    public final void setField24(final String field24) {
        this.field24Property().set(field24);
    }

    public final SimpleStringProperty field25Property() {
        return this.field25;
    }

    public final String getField25() {
        return this.field25Property().get();
    }

    public final void setField25(final String field25) {
        this.field25Property().set(field25);
    }

    public final SimpleStringProperty field26Property() {
        return this.field26;
    }

    public final String getField26() {
        return this.field26Property().get();
    }

    public final void setField26(final String field26) {
        this.field26Property().set(field26);
    }

    public final SimpleStringProperty field27Property() {
        return this.field27;
    }

    public final String getField27() {
        return this.field27Property().get();
    }

    public final void setField27(final String field27) {
        this.field27Property().set(field27);
    }

    public final SimpleStringProperty field28Property() {
        return this.field28;
    }

    public final String getField28() {
        return this.field28Property().get();
    }

    public final void setField28(final String field28) {
        this.field28Property().set(field28);
    }

    public final SimpleStringProperty field29Property() {
        return this.field29;
    }

    public final String getField29() {
        return this.field29Property().get();
    }

    public final void setField29(final String field29) {
        this.field29Property().set(field29);
    }

    public final SimpleStringProperty field30Property() {
        return this.field30;
    }

    public final String getField30() {
        return this.field30Property().get();
    }

    public final void setField30(final String field30) {
        this.field30Property().set(field30);
    }

    public final SimpleStringProperty field31Property() {
        return this.field31;
    }

    public final String getField31() {
        return this.field31Property().get();
    }

    public final void setField31(final String field31) {
        this.field31Property().set(field31);
    }

    public final SimpleStringProperty field32Property() {
        return this.field32;
    }

    public final String getField32() {
        return this.field32Property().get();
    }

    public final void setField32(final String field32) {
        this.field32Property().set(field32);
    }

    public final SimpleStringProperty field33Property() {
        return this.field33;
    }

    public final String getField33() {
        return this.field33Property().get();
    }

    public final void setField33(final String field33) {
        this.field33Property().set(field33);
    }

    public final SimpleStringProperty field34Property() {
        return this.field34;
    }

    public final String getField34() {
        return this.field34Property().get();
    }

    public final void setField34(final String field34) {
        this.field34Property().set(field34);
    }

    public final SimpleStringProperty field35Property() {
        return this.field35;
    }

    public final String getField35() {
        return this.field35Property().get();
    }

    public final void setField35(final String field35) {
        this.field35Property().set(field35);
    }

    public final SimpleStringProperty field36Property() {
        return this.field36;
    }

    public final String getField36() {
        return this.field36Property().get();
    }

    public final void setField36(final String field36) {
        this.field36Property().set(field36);
    }

    public final SimpleStringProperty field37Property() {
        return this.field37;
    }

    public final String getField37() {
        return this.field37Property().get();
    }

    public final void setField37(final String field37) {
        this.field37Property().set(field37);
    }

    public final SimpleStringProperty field38Property() {
        return this.field38;
    }

    public final String getField38() {
        return this.field38Property().get();
    }

    public final void setField38(final String field38) {
        this.field38Property().set(field38);
    }

    public final SimpleStringProperty field39Property() {
        return this.field39;
    }

    public final String getField39() {
        return this.field39Property().get();
    }

    public final void setField39(final String field39) {
        this.field39Property().set(field39);
    }

    public final SimpleStringProperty field40Property() {
        return this.field40;
    }

    public final String getField40() {
        return this.field40Property().get();
    }

    public final void setField40(final String field40) {
        this.field40Property().set(field40);
    }

    public final SimpleStringProperty field41Property() {
        return this.field41;
    }

    public final String getField41() {
        return this.field41Property().get();
    }

    public final void setField41(final String field41) {
        this.field41Property().set(field41);
    }

    public final SimpleStringProperty field42Property() {
        return this.field42;
    }

    public final String getField42() {
        return this.field42Property().get();
    }

    public final void setField42(final String field42) {
        this.field42Property().set(field42);
    }

    public final SimpleStringProperty field43Property() {
        return this.field43;
    }

    public final String getField43() {
        return this.field43Property().get();
    }

    public final void setField43(final String field43) {
        this.field43Property().set(field43);
    }

    public final SimpleStringProperty field44Property() {
        return this.field44;
    }

    public final String getField44() {
        return this.field44Property().get();
    }

    public final void setField44(final String field44) {
        this.field44Property().set(field44);
    }

    public final SimpleStringProperty field45Property() {
        return this.field45;
    }

    public final String getField45() {
        return this.field45Property().get();
    }

    public final void setField45(final String field45) {
        this.field45Property().set(field45);
    }

    public final SimpleStringProperty field46Property() {
        return this.field46;
    }

    public final String getField46() {
        return this.field46Property().get();
    }

    public final void setField46(final String field46) {
        this.field46Property().set(field46);
    }

    public final SimpleStringProperty field47Property() {
        return this.field47;
    }

    public final String getField47() {
        return this.field47Property().get();
    }

    public final void setField47(final String field47) {
        this.field47Property().set(field47);
    }

    public final SimpleStringProperty field48Property() {
        return this.field48;
    }

    public final String getField48() {
        return this.field48Property().get();
    }

    public final void setField48(final String field48) {
        this.field48Property().set(field48);
    }

    public final SimpleStringProperty field49Property() {
        return this.field49;
    }

    public final String getField49() {
        return this.field49Property().get();
    }

    public final void setField49(final String field49) {
        this.field49Property().set(field49);
    }

    public final SimpleStringProperty field50Property() {
        return this.field50;
    }

    public final String getField50() {
        return this.field50Property().get();
    }

    public final void setField50(final String field50) {
        this.field50Property().set(field50);
    }

    public final SimpleStringProperty field51Property() {
        return this.field51;
    }

    public final String getField51() {
        return this.field51Property().get();
    }

    public final void setField51(final String field51) {
        this.field51Property().set(field51);
    }

    public final SimpleStringProperty field52Property() {
        return this.field52;
    }

    public final String getField52() {
        return this.field52Property().get();
    }

    public final void setField52(final String field52) {
        this.field52Property().set(field52);
    }

    public final SimpleStringProperty field53Property() {
        return this.field53;
    }

    public final String getField53() {
        return this.field53Property().get();
    }

    public final void setField53(final String field53) {
        this.field53Property().set(field53);
    }

    public final SimpleStringProperty field54Property() {
        return this.field54;
    }

    public final String getField54() {
        return this.field54Property().get();
    }

    public final void setField54(final String field54) {
        this.field54Property().set(field54);
    }

    public final SimpleStringProperty field55Property() {
        return this.field55;
    }

    public final String getField55() {
        return this.field55Property().get();
    }

    public final void setField55(final String field55) {
        this.field55Property().set(field55);
    }

    public final SimpleStringProperty field56Property() {
        return this.field56;
    }

    public final String getField56() {
        return this.field56Property().get();
    }

    public final void setField56(final String field56) {
        this.field56Property().set(field56);
    }

    public final SimpleStringProperty field57Property() {
        return this.field57;
    }

    public final String getField57() {
        return this.field57Property().get();
    }

    public final void setField57(final String field57) {
        this.field57Property().set(field57);
    }

    public final SimpleStringProperty field58Property() {
        return this.field58;
    }

    public final String getField58() {
        return this.field58Property().get();
    }

    public final void setField58(final String field58) {
        this.field58Property().set(field58);
    }

    public final SimpleStringProperty field59Property() {
        return this.field59;
    }

    public final String getField59() {
        return this.field59Property().get();
    }

    public final void setField59(final String field59) {
        this.field59Property().set(field59);
    }

    public final SimpleStringProperty field60Property() {
        return this.field60;
    }

    public final String getField60() {
        return this.field60Property().get();
    }

    public final void setField60(final String field60) {
        this.field60Property().set(field60);
    }

    public final SimpleStringProperty field61Property() {
        return this.field61;
    }

    public final String getField61() {
        return this.field61Property().get();
    }

    public final void setField61(final String field61) {
        this.field61Property().set(field61);
    }

    public final SimpleStringProperty field62Property() {
        return this.field62;
    }

    public final String getField62() {
        return this.field62Property().get();
    }

    public final void setField62(final String field62) {
        this.field62Property().set(field62);
    }

    public final SimpleStringProperty field63Property() {
        return this.field63;
    }

    public final String getField63() {
        return this.field63Property().get();
    }

    public final void setField63(final String field63) {
        this.field63Property().set(field63);
    }

    public final SimpleStringProperty field64Property() {
        return this.field64;
    }

    public final String getField64() {
        return this.field64Property().get();
    }

    public final void setField64(final String field64) {
        this.field64Property().set(field64);
    }

    public final SimpleStringProperty field65Property() {
        return this.field65;
    }

    public final String getField65() {
        return this.field65Property().get();
    }

    public final void setField65(final String field65) {
        this.field65Property().set(field65);
    }

    public final SimpleStringProperty field66Property() {
        return this.field66;
    }

    public final String getField66() {
        return this.field66Property().get();
    }

    public final void setField66(final String field66) {
        this.field66Property().set(field66);
    }

    public final SimpleStringProperty field67Property() {
        return this.field67;
    }

    public final String getField67() {
        return this.field67Property().get();
    }

    public final void setField67(final String field67) {
        this.field67Property().set(field67);
    }

    public final SimpleStringProperty field68Property() {
        return this.field68;
    }

    public final String getField68() {
        return this.field68Property().get();
    }

    public final void setField68(final String field68) {
        this.field68Property().set(field68);
    }

    public final SimpleStringProperty field69Property() {
        return this.field69;
    }

    public final String getField69() {
        return this.field69Property().get();
    }

    public final void setField69(final String field69) {
        this.field69Property().set(field69);
    }

    public final SimpleStringProperty field70Property() {
        return this.field70;
    }

    public final String getField70() {
        return this.field70Property().get();
    }

    public final void setField70(final String field70) {
        this.field70Property().set(field70);
    }

    public final SimpleStringProperty field71Property() {
        return this.field71;
    }

    public final String getField71() {
        return this.field71Property().get();
    }

    public final void setField71(final String field71) {
        this.field71Property().set(field71);
    }

    public final SimpleStringProperty field72Property() {
        return this.field72;
    }

    public final String getField72() {
        return this.field72Property().get();
    }

    public final void setField72(final String field72) {
        this.field72Property().set(field72);
    }

    public final SimpleStringProperty field73Property() {
        return this.field73;
    }

    public final String getField73() {
        return this.field73Property().get();
    }

    public final void setField73(final String field73) {
        this.field73Property().set(field73);
    }

    public final SimpleStringProperty field74Property() {
        return this.field74;
    }

    public final String getField74() {
        return this.field74Property().get();
    }

    public final void setField74(final String field74) {
        this.field74Property().set(field74);
    }

    public final SimpleStringProperty field75Property() {
        return this.field75;
    }

    public final String getField75() {
        return this.field75Property().get();
    }

    public final void setField75(final String field75) {
        this.field75Property().set(field75);
    }

    public final SimpleStringProperty field76Property() {
        return this.field76;
    }

    public final String getField76() {
        return this.field76Property().get();
    }

    public final void setField76(final String field76) {
        this.field76Property().set(field76);
    }

    public final SimpleStringProperty field77Property() {
        return this.field77;
    }

    public final String getField77() {
        return this.field77Property().get();
    }

    public final void setField77(final String field77) {
        this.field77Property().set(field77);
    }

    public final SimpleStringProperty field78Property() {
        return this.field78;
    }

    public final String getField78() {
        return this.field78Property().get();
    }

    public final void setField78(final String field78) {
        this.field78Property().set(field78);
    }

    public final SimpleStringProperty field79Property() {
        return this.field79;
    }

    public final String getField79() {
        return this.field79Property().get();
    }

    public final void setField79(final String field79) {
        this.field79Property().set(field79);
    }

    public final SimpleStringProperty field80Property() {
        return this.field80;
    }

    public final String getField80() {
        return this.field80Property().get();
    }

    public final void setField80(final String field80) {
        this.field80Property().set(field80);
    }

    public final SimpleStringProperty field81Property() {
        return this.field81;
    }

    public final String getField81() {
        return this.field81Property().get();
    }

    public final void setField81(final String field81) {
        this.field81Property().set(field81);
    }

    public final SimpleStringProperty field82Property() {
        return this.field82;
    }

    public final String getField82() {
        return this.field82Property().get();
    }

    public final void setField82(final String field82) {
        this.field82Property().set(field82);
    }

    public final SimpleStringProperty field83Property() {
        return this.field83;
    }

    public final String getField83() {
        return this.field83Property().get();
    }

    public final void setField83(final String field83) {
        this.field83Property().set(field83);
    }

    public final SimpleStringProperty field84Property() {
        return this.field84;
    }

    public final String getField84() {
        return this.field84Property().get();
    }

    public final void setField84(final String field84) {
        this.field84Property().set(field84);
    }

    public final SimpleStringProperty field85Property() {
        return this.field85;
    }

    public final String getField85() {
        return this.field85Property().get();
    }

    public final void setField85(final String field85) {
        this.field85Property().set(field85);
    }

    public final SimpleStringProperty field86Property() {
        return this.field86;
    }

    public final String getField86() {
        return this.field86Property().get();
    }

    public final void setField86(final String field86) {
        this.field86Property().set(field86);
    }

    public final SimpleStringProperty field87Property() {
        return this.field87;
    }

    public final String getField87() {
        return this.field87Property().get();
    }

    public final void setField87(final String field87) {
        this.field87Property().set(field87);
    }

    public final SimpleStringProperty field88Property() {
        return this.field88;
    }

    public final String getField88() {
        return this.field88Property().get();
    }

    public final void setField88(final String field88) {
        this.field88Property().set(field88);
    }

    public final SimpleStringProperty field89Property() {
        return this.field89;
    }

    public final String getField89() {
        return this.field89Property().get();
    }

    public final void setField89(final String field89) {
        this.field89Property().set(field89);
    }

    public final SimpleStringProperty field90Property() {
        return this.field90;
    }

    public final String getField90() {
        return this.field90Property().get();
    }

    public final void setField90(final String field90) {
        this.field90Property().set(field90);
    }

    public final SimpleStringProperty field91Property() {
        return this.field91;
    }

    public final String getField91() {
        return this.field91Property().get();
    }

    public final void setField91(final String field91) {
        this.field91Property().set(field91);
    }

    public final SimpleStringProperty field92Property() {
        return this.field92;
    }

    public final String getField92() {
        return this.field92Property().get();
    }

    public final void setField92(final String field92) {
        this.field92Property().set(field92);
    }

    public final SimpleStringProperty field93Property() {
        return this.field93;
    }

    public final String getField93() {
        return this.field93Property().get();
    }

    public final void setField93(final String field93) {
        this.field93Property().set(field93);
    }

    public final SimpleStringProperty field94Property() {
        return this.field94;
    }

    public final String getField94() {
        return this.field94Property().get();
    }

    public final void setField94(final String field94) {
        this.field94Property().set(field94);
    }

    public final SimpleStringProperty field95Property() {
        return this.field95;
    }

    public final String getField95() {
        return this.field95Property().get();
    }

    public final void setField95(final String field95) {
        this.field95Property().set(field95);
    }

    public final SimpleStringProperty field96Property() {
        return this.field96;
    }

    public final String getField96() {
        return this.field96Property().get();
    }

    public final void setField96(final String field96) {
        this.field96Property().set(field96);
    }

    public final SimpleStringProperty field97Property() {
        return this.field97;
    }

    public final String getField97() {
        return this.field97Property().get();
    }

    public final void setField97(final String field97) {
        this.field97Property().set(field97);
    }

    public final SimpleStringProperty field98Property() {
        return this.field98;
    }

    public final String getField98() {
        return this.field98Property().get();
    }

    public final void setField98(final String field98) {
        this.field98Property().set(field98);
    }

    public final SimpleStringProperty field99Property() {
        return this.field99;
    }

    public final String getField99() {
        return this.field99Property().get();
    }

    public final void setField99(final String field99) {
        this.field99Property().set(field99);
    }

}

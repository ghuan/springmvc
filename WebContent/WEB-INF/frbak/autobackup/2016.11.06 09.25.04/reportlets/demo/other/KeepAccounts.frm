<?xml version="1.0" encoding="UTF-8"?>
<Form xmlVersion="20151125" releaseVersion="8.0.0">
<TableDataMap>
<TableData name="各个国家中产阶级人数" class="com.fr.data.impl.EmbeddedTableData">
<Parameters/>
<DSName>
<![CDATA[]]></DSName>
<ColumnNames>
<![CDATA[国家,,.,,人数,,.,,经度,,.,,纬度]]></ColumnNames>
<ColumnTypes>
<![CDATA[java.lang.String,java.lang.String,java.lang.String,java.lang.String]]></ColumnTypes>
<RowData>
<![CDATA[7?QJBPX,_sY;>XQ@?O<IanmMh9A9hOnII&-<XZ>a/Zi"-^<Fl?I1,YSheqUl(k-POaiV''\m
O:p&M0/#=P72.?pP6)[+889X3:&+gN[_H^3r5n,_GGVU,2/??q'c9dE?e1H#n4s+-K9^C+.?
^lX!^'8ZJ/Cn`>*%(pB5]Ab,C`%b?gJ<9q#*4s$!!5%tB-ML`P;&R-Wd@&B1T9a@jZm:X6ESm
soJZN7jf4aV%drApNqBNQO6W3GqWD)gKCWmX<,7i//F^4Zg0$4o$JEa<[asUE#^GZ^^T-J,&
>\lB?G8I[m%M<YY"&drBLd;j;!\P\o""%_2m$[@jgNG4J`sE9,NIk-A?UVCc5#MTkd;\bZ"&
N3gNa\]A2^XP+cXVgrae_4P9nU+r$TX#OSAnENE$$>5pd9.%"eIC.P$22OiCLE&X4dpAB78k=
q-"i]A=PGrrW~
]]></RowData>
</TableData>
</TableDataMap>
<Parameters/>
<Layout class="com.fr.form.ui.container.WBorderLayout">
<WidgetName name="form"/>
<WidgetAttr>
<PrivilegeControl/>
</WidgetAttr>
<Margin top="0" left="0" bottom="0" right="0"/>
<Border>
<border style="0" color="-723724" type="0" borderStyle="0"/>
<WidgetTitle>
<O>
<![CDATA[新建标题]]></O>
<FRFont name="SimSun" style="0" size="72"/>
<Position pos="0"/>
</WidgetTitle>
<Alpha alpha="1.0"/>
</Border>
<LCAttr vgap="0" hgap="0" compInterval="0"/>
<Center class="com.fr.form.ui.container.WFitLayout">
<WidgetName name="body"/>
<WidgetAttr>
<PrivilegeControl/>
</WidgetAttr>
<Margin top="1" left="1" bottom="1" right="1"/>
<Border>
<border style="0" color="-723724" type="0" borderStyle="0"/>
<WidgetTitle>
<O>
<![CDATA[新建标题]]></O>
<FRFont name="SimSun" style="0" size="72"/>
<Position pos="0"/>
</WidgetTitle>
<Background name="ColorBackground" color="-14605511"/>
<Alpha alpha="1.0"/>
</Border>
<Background name="ColorBackground" color="-14605511"/>
<LCAttr vgap="0" hgap="0" compInterval="0"/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.container.WTitleLayout">
<WidgetName name="report0"/>
<WidgetAttr>
<PrivilegeControl/>
</WidgetAttr>
<Margin top="0" left="0" bottom="0" right="0"/>
<Border>
<border style="0" color="-723724" type="0" borderStyle="0"/>
<WidgetTitle>
<O>
<![CDATA[新建标题]]></O>
<FRFont name="SimSun" style="0" size="72"/>
<Position pos="0"/>
</WidgetTitle>
<Alpha alpha="1.0"/>
</Border>
<LCAttr vgap="0" hgap="0" compInterval="0"/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.ElementCaseEditor">
<WidgetName name="report0"/>
<WidgetAttr>
<PrivilegeControl/>
</WidgetAttr>
<Margin top="1" left="1" bottom="1" right="1"/>
<Border>
<border style="0" color="-723724" type="0" borderStyle="0"/>
<WidgetTitle>
<O>
<![CDATA[新建标题]]></O>
<FRFont name="SimSun" style="0" size="72"/>
<Position pos="0"/>
</WidgetTitle>
<Alpha alpha="1.0"/>
</Border>
<FormElementCase>
<ReportPageAttr>
<HR/>
<FR/>
<HC/>
<FC/>
</ReportPageAttr>
<ColumnPrivilegeControl/>
<RowPrivilegeControl/>
<RowHeight defaultValue="723900">
<![CDATA[762000,1257300,723900,1903680,1903680,1903680,1903680,1903680,1903680,1903680,1903680,723900]]></RowHeight>
<ColumnWidth defaultValue="2743200">
<![CDATA[381000,1903680,1903680,1903680,1903680,1903680,1903680,1903680,2743200,2743200,2743200]]></ColumnWidth>
<CellElementList>
<C c="0" r="0" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="0" cs="2" s="1">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=now()]]></Attributes>
</O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="0" s="2">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=weekday(now())]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性1]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[2]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期二]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[3]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期三]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性3]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[4]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期四]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性4]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[5]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期五]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性5]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[6]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期六]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性6]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[7]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期日]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性7]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[1]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期一]]></O>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="0" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="0" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="0" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="0" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="1" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="1" cs="2" s="4">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=now()]]></Attributes>
</O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="2" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="2" s="5">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=weekday(todate(year(today()), month(today()), 1))]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性1]]></Name>
<Condition class="com.fr.data.condition.ListCondition"/>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.RowHeightHighlightAction"/>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="2" s="5">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=daysofmonth(today())]]></Attributes>
</O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="3" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="3" s="6">
<O t="I">
<![CDATA[0]]></O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性1]]></Name>
<Condition class="com.fr.data.condition.ListCondition"/>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.RowHeightHighlightAction"/>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="3" s="6">
<O t="I">
<![CDATA[1]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="3" s="6">
<O t="I">
<![CDATA[2]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="3" s="6">
<O t="I">
<![CDATA[3]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="3" s="6">
<O t="I">
<![CDATA[4]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="3" s="6">
<O t="I">
<![CDATA[5]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="3" s="6">
<O t="I">
<![CDATA[6]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="4" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="4" s="7">
<O>
<![CDATA[日]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="2" r="4" s="7">
<O>
<![CDATA[一]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="4" s="7">
<O>
<![CDATA[二]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="4" s="7">
<O>
<![CDATA[三]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="4" s="7">
<O>
<![CDATA[四]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="4" s="7">
<O>
<![CDATA[五]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="4" s="7">
<O>
<![CDATA[六]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="5" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="5" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 = 0, 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="5" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 1, 1 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="3" r="5" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 2, 2 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="5" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 3, 3 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="5" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 4, 4 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="5" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 5, 5 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="5" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 6, 6 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="6" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="6" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 1]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="6" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 2]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="3" r="6" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 3]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="6" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 4]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="6" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 5]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="6" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 6]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="6" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 7]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="7" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="7" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 1]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="7" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 2]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand leftParentDefault="false" upParentDefault="false"/>
</C>
<C c="3" r="7" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 3]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="7" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 4]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="7" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 5]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="7" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 6]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="7" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 7]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="8" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="8" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 1]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="8" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 2]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand leftParentDefault="false" upParentDefault="false"/>
</C>
<C c="3" r="8" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 3]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="8" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 4]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="8" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 5]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="8" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 6]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="8" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 7]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="9" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="9" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H9 + 1]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="9" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H9 + 2]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand leftParentDefault="false" upParentDefault="false"/>
</C>
<C c="3" r="9" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 3 <= C3, H9 + 3, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="9" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 4 <= C3, H9 + 4, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="9" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 5 <= C3, H9 + 5, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="9" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 6 <= C3, H9 + 6, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="9" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 7 <= C3, H9 + 7, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="10" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="10" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 8 <= C3, H9 + 8, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="10" s="8">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 9 <= C3, H9 + 9, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-16463659"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="3" r="10" s="8">
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="10" s="8">
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="10" s="8">
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="10" s="8">
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="10" s="8">
<PrivilegeControl/>
<Expand/>
</C>
</CellElementList>
<ReportAttrSet>
<ReportSettings headerHeight="0" footerHeight="0">
<PaperSetting/>
</ReportSettings>
</ReportAttrSet>
</FormElementCase>
<StyleList>
<Style imageLayout="1">
<FRFont name="SimSun" style="0" size="72"/>
<Background name="ColorBackground" color="-14605511"/>
<Border/>
</Style>
<Style imageLayout="1">
<Format class="java.text.SimpleDateFormat">
<![CDATA[yyyy年MM月dd日]]></Format>
<FRFont name="Verdana" style="0" size="72" foreground="-16721179"/>
<Background name="ColorBackground" color="-14605511"/>
<Border/>
</Style>
<Style imageLayout="1">
<FRFont name="Verdana" style="0" size="72" foreground="-16721179"/>
<Background name="ColorBackground" color="-14605511"/>
<Border/>
</Style>
<Style imageLayout="1">
<FRFont name="Verdana" style="0" size="72"/>
<Background name="ColorBackground" color="-14605511"/>
<Border/>
</Style>
<Style imageLayout="1">
<Format class="java.text.SimpleDateFormat">
<![CDATA[yyyy年MM月]]></Format>
<FRFont name="Verdana" style="0" size="96" foreground="-1"/>
<Background name="ColorBackground" color="-14605511"/>
<Border/>
</Style>
<Style horizontal_alignment="0" imageLayout="1">
<FRFont name="Verdana" style="0" size="72"/>
<Background name="ColorBackground" color="-14605511"/>
<Border/>
</Style>
<Style horizontal_alignment="0" imageLayout="1">
<FRFont name="Verdana" style="0" size="88" foreground="-1"/>
<Background name="ColorBackground" color="-14605511"/>
<Border>
<Top style="1" color="-14671321"/>
<Bottom style="1" color="-14671321"/>
<Left style="1" color="-14671321"/>
<Right style="1" color="-14671321"/>
</Border>
</Style>
<Style horizontal_alignment="0" imageLayout="1">
<FRFont name="Verdana" style="1" size="88" foreground="-1"/>
<Background name="ColorBackground" color="-13947574"/>
<Border>
<Top style="1" color="-14605511"/>
<Bottom style="1" color="-14605511"/>
<Left style="1" color="-14605511"/>
<Right style="1" color="-14605511"/>
</Border>
</Style>
<Style horizontal_alignment="0" imageLayout="1">
<FRFont name="Verdana" style="0" size="88" foreground="-1"/>
<Background name="ColorBackground" color="-13947574"/>
<Border>
<Top style="1" color="-14605511"/>
<Bottom style="1" color="-14605511"/>
<Left style="1" color="-14605511"/>
<Right style="1" color="-14605511"/>
</Border>
</Style>
</StyleList>
<showToolbar showtoolbar="false"/>
<heightRestrict heightrestrict="false"/>
<heightPercent heightpercent="0.75"/>
<IM>
<![CDATA[buoBQ<,:6lAOaR.cD%UAg,6mDPR`jMkWfPG-GiBK:j06H86SS[d;JE/&<[qf9[bVY6`o16C)
?,b)&-rTUd7mj8E"pHRPiWEp\V\^pKcZ@T5.]A`b^.k34SNpS^YaHcP*rIgVCLm^:RX+SlFOA
5*g7p:X2)I^"ThK^1OhSMBp+VP3X:#_J[YR@Q[f"@.dGY%s-00*WijN?`g_)liNF;O_,Srg\
m*Cllo@M@hQ]A8#PAB3DG;%\s@]A*$uZK4]AZ+m#pK3[MV;T-)io@i+a>G,h!`gNN`3P0ql'Ugk
'J&+TfK1Oa<%DP*rR?-ff<+_pQtfcZtbNhafb@nULD-);F!Tt!5EV4nZjGt##/ZRo<"nA[&V
^48RPqs?5<,D?OrQt6.GH=7''<:GX7TY]AJ:G\OqeK\#nX(BTo,hLl^9RpY<u;o8ht:1t+04,
86CNZJ"AeDtch<*^+rR.uoYcV7mY4=mjLbq!6k[]A#F&=1'okHnno2l5S?1/Q)$9S2/>U^iW=
4q9l":`cA5KrH)_]A^m/0`j%VtbjtbEu7pj7UJYqqFie8)XTSo7+Ee8SLUl521ddJci/?K'#%
B+=%/X>@04mG>!/q!s7OQ&`R.]Aus]ABA.@tR=`[!V;6d<]A/6E.O1F+3Tp3u!1kfhSZ9?FoZh<
N[/'IW-\!kFe:!kb+YBgT?3BN!edQYe:a4i\2GW/8([Rgq1BWR-bW.(SN]Aq&7OS/2O^<-UM/
FZNHq2B>Z@@QHNdnK_=,I6+):_ue@qT4?$t84i8-PU:D)n9!%^?HWMTh:Rn#@CO6Rkle22pg
["C%C9^\2bU+928FN@5-Xo.?U#"%d`NJ2m0Fg(pER*,UUS"56(1/MA&1-=mPn-.X2%pUOaM(
-R$`JgC9.-lJi>V963\)njJFd,K_5s&mq@Op5(g1t);[=!pT?Mt"^UgDnt_UNm9$0p4\G?Z.
Xd]AqH0]A4k]AWdd%d3&ATbM,^$B0GYKa#C-mciZfs!ha"PM17E#IKNU5?Src=Wi0U[0Vj@R=-t
QUU`QAj:Bf$^):*U4Stq77FD,e`$;0R;@jUV$f[aL0oST85]A;KqL$r9Xf=Top';]ASeDd<T\)
(3X/&&)An#PV))oOq*Lj/;X`tF('i"H*Cb^i\BO']Ae$iJ'*maE!p4ORW)'<'l9D!kPO`E.=I
O?J>R##27f^n.qDcF0kOr9'^ogIn%DR2!q(mJ5F6LHap=H=,`#7HrXiI%&%0b!ICtEjd0BsV
HBR;$Z+BL,P2X8'CR\l&m77Tto"RQGo06WBM]A*2lt9UHG4H=8>VHWlCIqPH+m5kU-"SJoAlM
51KPIl42,aZ9t[I[.pRoB%-`/Y=gXrTSbU%65b!%Kijt._pdBIR2lf$D!CC:G?0]A%qud#>7^
$oQRhhd.<Eg$ViI5jV\9&e@(]AX3IGZgla!LMgD#O4Vni-#0q^_h[8h$S\@s@@,'Z`c7P_mY8
:'!P/=sDL.)dq6;P3iW@a`auC/qdQJHstrh1.FVDq`Egbg(06i!X?TEfKOag:UD=sGN`c(=R
<?H[sT9%9HWJ?cUP3532S8GJW!uJ>QQEWPBF=I,In2UFY[Ir$Qs0q("0aUmmCFe57Y/X)1(3
h+srOqBL`V:kE-6gmO<?R&[MWq&cI(/q\oiZP-"O;!bW\r_YSaMZnE>%@LQq1AANDdeJ_s`o
/r"@$<Qe$FLh8"n)7Q,37TJNf$SO$#alWGr/Ks?W,h4+*CI>-\5$T.b=0I`,:6I.-U&m/0=[
7_(\RjRfuQE!;;M7$,4qni7Fe3/b1a330ibZLK"<eFh<]A1&V/Is>;NtlHn"PN-mbUm4P7%1\
[`^eB?m_WBKS,`r3.ocXg),eEj.tV@71;GmVWN8*AHrS[-`^u]A1Wq1@)*=Op%/;dc$F/2:7B
1%E(neEq6Vuts4.$.5N\.!a$?Q,3.SL@Hq'iQXM':+e*"t(F`DH6(3Gh!K98ZW7B)[rEf%i;
FNN(&K?QL6&RFcS\TYObk!r3n`gch[K#!UFKn:sfmTpT*IN>(-&;!Ke>;lUK^k0=Y,3-0a>h
t'u4\#7>LS9uLA0WXb+8%?;:;"?e-I.T.ioWH;QF-9:slBl*8V,U4mZN[2T$6e#s7STrolqj
>n$eAhU-%W]A>BHbXAZJB&u[Sm.#q1T868NQ9Y5_lUP1.gYa]A>;&7QJKSVqt%M`dfAHH6.HRC
Q4c%0m.^4Z6gq$o?fRJ@dUDoNA7"!rc<@i\Mm?1<_bBdOkCMLVdM\[#H.FX9f@0($Ut@gX>r
q#+fIXFQPAjpcbQW"RrJWb&d,*k?Brm'u/`>)0mGjH<YgEBDF8:nqo\VJ7?6N&A\)tJ#NB&+
h8pg%c*g6N?g4'd/r[4THgt?7*T+8g0ROZDqHE5%SG)OVJ2s2>GZT_cAh6/j7,ZlS\_E%T+c
:OS!ga:lX1WQR-J7k#,).,)i++a.!V<lrD:531Xk(`C^ioD<1,R=.S$`m+u<dGQHdTi:`p22
SS%F^=7V)$/l>M,r;3PV_b$0#t?A@aPjG(:;d/&GWQmdW!7`\"JeE2C,/VKY:qs4H-Zh93nU
LX`GGlJQ1Xrnu/R2o7D9Es1UR"[`NS/0V#*83sb?QI$B38X'jJqB_DNrh:PC,&_knSHn033T
m2GR,rd]A#1&d%O4]AI#B2eXr,Y")^jZ1ET.8Fh99TgIsUYm6P!0P(E:\Rbl&2Z1E`i:[D5W;G
5pB9'k`jYmQR?$dD2eco,B?Zk`O.eQ:IZ(_f'kaNqp"aru:.q]AM\m7769jr:bT9Ij-X4(O)[
8NbEdk$#s5-k_Jl?r(MriE/R6%R$,XIAtbdo,O7,duj4Qe2@,hMn-)1RZS-%oMY=]Am"$,lh?
$^?\j!FCF6Nc7OreD1+b1&.Ue3!NLhZ6=[^@*KWNXt\<$\Jh&X5BDj=RL%oUTB"8+[HNX[68
^W(7FdMNUT)=WkJ\&uq7X0sD%IXMLnU1+q_",oLBT6BUZ$*REF%*smHWX2G/L'-X*`*b,skd
%g$m9FYf*@I2f-TpEdULN8K9D#(5,HmX1O*D17l>;,TSGL"IZ*ZkC0HQu>[gdCQ_/RHm,"@Y
<aNV@ZhI9AO=O,B.inpX9IRgAHZ^r\$#Bg#dN]A>4MoR,m>FdqgJYQg"M/CqW-`TLa-J+NQ3e
N&C#an>!)II[r<-cuU=W$U_"eg1_urs>M@aYkTU6^mrk#Ns#nn[C_:MD[<-!YX.:>CMh(#0/
R+:#?<SNFI%kcc$KR(&QV><Yt/+8ZTMJ@JZf$%IcQNhrYEDde%@TF&L">Im.&OLg2KPZ+O9*
K&'bA]A,P4;?EE$[hY2e^C+tR`?Y@g9%)Nk=8teDRF+uT>k73:ZBd&S<[P'goi^GX<S4TscCf
kfp%Ab$.%#:B)2ILOm?ns948@;=QmCtDLRl_Lof!25(ecVJ[R('g]AL`*R#ZmJ2khl.PS\fO%
]A70tC?Q$k>cSV$"(-N9'Yjo:D[/Z[gg;c3'h#*uX?Gd?I.phjtT`$uR@c$0.FVrF+Ul$jTY\
bAc`ctKRMF`*4.`?V>2@'=GlD-AA)mFklqc]A,EG/:CtBjQSf9fbfB1%88[NqI[0JT!bolA!Z
se@d-pid]A%cAhHY/67jh#O)L<=d(GOpY_0K*m#X"kdARqQMG;[IgQrogM9VW!=^sm0-0^@j?
K*9=:EGW=RW[nN)cFW@o&>gG!a\]A!*bsY;P8,*VHaf>\&f4qR/D[i&JplOH"4=:j;XTmEsUX
Sh'I4kKT4Bn<k.0('q@OS/1J.2/5H=.FHXWr/c\`j>AB#ZjTY'dV2C?9_`T^uX:Lsap#`A":
ZbjVdS-e&I<,=o'``pC]AQN/&t5U%Cq545M(4EKbGH2kdH<;ltHdQ3Jq,J`;<_Si4h#o/_./7
JU.hZm?B_2R.DWoL"-=39;"dAQ);T6WsI6kRITcZ_3htqLiuaDsGFR%;=/hX7"kSEe^Qd<bh
OY*6Ws'(O&1+MHF#fZJtDYM84'&<U!<YRn'eeHcP-0`3nk.Q^Tj_D#/!;`R@Id*=5iVc"8./
+U<4:G"@cRmgnlSmJnnb]Aj/n/m_,eBODY(ZF60#lf,rIAhHV/FhS[_I#k3P34.Fp-TBE7W.[
CD:1nm_`Cc*mBN@ZntiiNWk;iLssqn)S['Gg'a+7uUX5fi,T03'8"8a05'UEL90hC?:4K/cn
A8IdG5i`IsH_oT@3H#el@UuhmiY8jEj`5f.@I`3k6jFIYd8>X&^kNL`!%:RrqGFZK+ihRplO
1]AA,HOr/Lg<R1=Qqq0YWRlR_j0Q,dkD[srXMsh:-==SLIlR1(H>n[IJ?O$e5OU;l"0tB2..*
$qQ;oTEE0&;Ts*Ip!e.ga;jBFb7!E\f<;o_OSr*K(t-2\jqP<2.t%M!!5\'g:1n7CZeN(>f3
r!3>MJZsG?h5<ZU5ADEu^E8F$16dP2%C/a]A'Wl;@;=RELQMm*5>upRXnSm4!U48ZCL!^&I7;
mN7]AmEDe+\!3r/r<dpK?3Q47@QZ4GtWu"o/1rk)@E@MgpX^O@p(l7!ua.D+hh:U$fm9NSc,n
cG@HHHU9;k(&T3@UdsN.5T9\@0rmOe-AC9J-'HYaTn"#(-M=;Z>-?n&pB5qr*J;Yma%6q6k,
>?IIL;'cAJ$=XB[,mVuij=Pp/@-$ZP-B6Q+*C>A^%[M%c&*[-L)K=9]ATr4l</r"pG0'NUo1L
K]A!Z@0rhj"O_YO$qu4pfWt&*@%4RZAkP5IBNO0CU`/4!Sm/`Qp_4\e#=Clo[T8REg2rOAY-=
F*kBuD(KQe[CU`rZjh'TbeF8QStQVg@X1I:[%d6>kRgSJ?l`tAkPZcI[iV]A,/?ZF]A$r`_)JX
88+3*2Mcf_c\S`B1qtaZ?,C9r9i+X$_Tt<XqO"^5?+g\7pfL\]A5^HXB?Fs#r*`C8)JB@1ru_
l+7'RJ(P]A^?R8'Xk_Ye[4S=a8d[m#C9\I\86^ApmY\7=u%%+',8m/#mrK*);/g7&;d(mt;=7
VB"sCL3V?>%#f@g?,1#_2!F;bd8+3%""EZ?U/Zk,q<P4;'Z)KG@Ck]A!P?L#(4QidruALcT)E
Te"O2@2]A[@JL"VU`uR;/q_[%C!%hcQ-den;rj3_]AZ&o^7B1IiV<dDI1OA+R_+XL6V29,3167
3;2E(IBAOD-HH<pA8,-+<3G1d$S^ft7'0/0e`MT@A!Q8XTOd25O#S1[,\'WAPB9^,_DMeAgi
E"/.+JV/qdAF83_2a?'M@70*W#Q`NI-N_A7#.9XUoC[p9#M?d4tdVUp?b^(EA,D`&qeEK^*Q
tXVpnBR_G+?''+ng#oC8C!HPY*eF<7PK@E`/Uk#`&T\0[o>725#1Tatr&rRF[V)C^Keso':=
mm-^[YIEn6^99beLG&h`q!Jtp)%0I5,Y$jC^#GV;C[mJg]AZoRDs,&;_FKNN;*bTu0j5(0K.;
"@D<8KCIqc^@RVmLPau@lo\lUpu#$H8jpQf-,#?`GA3*N_XE>;[dS(YCY3*)d%DN1hI*"$X#
l*D+0Q-RkoT3/R)BP1/id46.0Bujsue8MbbK;3O.VV@<2,JVGdqYoEDalQBE9F6:Clu!<5*6
1Nc'ZD*7%o3sO46QX2(cj&o-YJJ7V3*_!d+i$BM<h:5P(6rBK59E$3kbE"KqH<k*")Yn^Ele
g2\"RZCQ#HA</o/5m^gR,g;YNk6!MW4HpXQt:k#WO$*Ab>lquX9DP=Rf[,fg4$UXu?[2%V)f
grt_Ut*N'_Yd;2R6IRBr*1pO+u'b\MYDdkO(]A@Tg,HPZaA_7.AlmRfG1c8d//eGOJEq8mR:%
GCEW1U+I4^WQni>Ofb1ER"/o:^9m2iY/B7hi@3S*GY#8tBD?htu;(>%.m%$Rj*U9Z69_D3TA
F,s^P,)u9:C?GS.(SO7gdqL=e"K,@lT65Q]AN3>F3m(c.gcH&b[1,_(;ppAK>KV/Wr9C=H88#
&\?rDSZ`]AS/*K9&0l\=;_`,B`_mhSNQbNK2O4klZq=$]A;:&:FV;m&W<i<mJ&kg]A-"5#jd*^N
8O2V]AXJ97Y`2f";OY=J-KH^d69[<<pDGfd6L0P1<oqd>6hYXB<IZ(7SQ)Ah=UjO04_NQ#`>O
F2'NW+Dh.R(gF8,<m:F6sGhJ5fsGbQ5)6>3J(iN:9:q`g^L:5#$=<f0Cl^7i>+X%li6fH1!>
/3DA6?N"aWR2Uu,7i$BZ.BW,Xuc>,ZE_%g;7EC,O97@uED]A7#+-:hEFPO;oaMreME3#47BTc
Nf),>:H]AFK$b73AhA7WgA"u,@?COS_21S4A`WT3VX`RdC_k+\]A]A6LE5i>%CY\=BBk+r6J/]AD
X_TrafG3oQ^u\BlaG>cKN3s/e0&i)`f(kiC?O.jCM2LhLA5oWNM/m5P6U9EK$=\Y/Or;OB<s
iW]ACoDf=tm554H@6oECJcfBn=KSs:!6Gti!<ce7/rJVjAFRY>/&PAK&Sk;W^VZ0aU?jKP_%S
mY^i5LB)LGtIJEB+_s=dlcr@RR\lmj.'Jl5$07s(*E>(!XbYq/8+\-AO"OO]A)^#MUgn93.Nl
-@m&H\C0Gn.2E3;fkIANSo+]A5fG%6!5mKtc*5(.$E;@mBZ9R(X!S[r$\qPONWs$2d0KL5O1W
_5^V1!S&Y]AHXcrE:E,-#32LO4&sSbK[%`6mloVHuD:!q#/]A?1jORg0R,7:<SoR->c"*fR%-l
]Aelbrk,7pa?mOk.d%\^DgV\(+c8XDk(*3^_;TT'\nVNa2MFGg[8pg;C_?a4s&H5EA)&V2r<t
T#A]A20'a&igEo5'F1650fOkoe?88L]AWTd9lU>NKk-n`oR<HF?O+Qa-fj\JHmj]A\]AC2B+Ys)C
MH-'ms@mNl,-bWnf35:`.tjT'"d]A-\@hNlGF'X?^7H1R)0;Cd+s"Rd_4^N#kZ4]AWLU;mgP&!
nZMrZ`$\WH#.CU7ETTQe`<5R@T.-G(liLT5NYQW]A8Kod$0CVTYQ$K4MPE;@5WKhEL\LRq)mP
,L:e(]ALNG'->R=rZb7OF-BG9ba`o+^,mL*b\UoqA-dKHZo$Wc&>\Zof@;]AXj-#6WC\j*b;=0
u[%>IY%.0-R3),MCt]AYN7j1=BQKER'JG*"dN6^Ya*#ap!h2J,bnJu1>dWsk9l'T"Ap"aE&0)
Yppb>Ge[kOc8G4"FT;&*NN63fF0'nDnBHb,=W7):e(%%Nab-,N2n[?iS2iq-3a9a2>k[g!ml
t&3k2kgiLZ:,`@#T9(H;2tQ&Cq*`!QraBKRO'O=DdHE[M08!g)1SsYr*lIU+n/6ZD0%<!#hm
eP6S%Nc]Ar**#Y(T)c"*u/r0R'?[fIH]A\(o5A5g&I/EpLpC(CBFBk2CK,ZWPXpq8M[=>4+A6=
g1s1WW\#Pgg95d)+jG$n(Z1[N?DCm?)UZN,0=Us]A1cJhp/1Xe5`kbmAEYHMTA?nBEcFJFEV+
BZjZ=Im^gsi#?!j>>[68j+B4Png)PI#`qZ!hthEJLJd'?n`44)!eH1DN_g!P5YH3O2jrRfNA
l-9;;N8fKukGh13cn%/sITg!gD%e3c)s)`7O5;pT=H7b%Xj4LIUT!n^Wi^)/kTKP0S!LsF63
o_N=m"Qos4_E65koc4!h'-@Gm:'rKCK51?bVi,j)Y*_?E9E@KV0q>\jBSZW/7=p)HLs57Z8G
NR":d/2]A*]AAj;PHDMQd<)a=,7XFNE+(*]A,m[smN'?gA9WCX8;A>s^F!+PQ`#N6M;d8Wlu''d
=L$V(5$4I,#g]ARh-5c[kr@\,)=&C)%+uV<64p2YZ6Llm/"1KJ`AJFsAa9s,d]AMG\sM(O`eF<
XJ!k0o\bY]AGuoa$Kt*!i`KK)PGE6-+h[fB2J$NrNp2"&2DZ-?=2M<>X>s,Wuhf1WeF=JonXK
sGa81"-%GH>VcTW4<9j#18BCsq*Q]Ao(q<,VEg(]ATgfQCLZZ%KM';J$Kh6[+WoR\1l<?a!K.i
.qo8G2"@/+$:Fs'k]Al"%J#$BG++*Rb;D_nEhOaJQITa<\71m?d>d&\"r#^8Dg4]APJ_6EqaQ\
lEM93U()5<Vs?F(u0^NGR>%X\J.jM(Z~
]]></IM>
<ElementCaseMobileAttrProvider horizontal="1" vertical="0" zoom="true" isUseHTML="false"/>
</InnerWidget>
<BoundsAttr x="0" y="0" width="640" height="803"/>
</Widget>
<body class="com.fr.form.ui.ElementCaseEditor">
<WidgetName name="report0"/>
<WidgetAttr>
<PrivilegeControl/>
</WidgetAttr>
<Margin top="1" left="1" bottom="1" right="1"/>
<Border>
<border style="0" color="-723724" type="0" borderStyle="0"/>
<WidgetTitle>
<O>
<![CDATA[新建标题]]></O>
<FRFont name="SimSun" style="0" size="72"/>
<Position pos="0"/>
</WidgetTitle>
<Alpha alpha="1.0"/>
</Border>
<FormElementCase>
<ReportPageAttr>
<HR/>
<FR/>
<HC/>
<FC/>
</ReportPageAttr>
<ColumnPrivilegeControl/>
<RowPrivilegeControl/>
<RowHeight defaultValue="723900">
<![CDATA[762000,1257300,723900,1903680,1903680,1903680,1903680,1903680,1903680,1903680,1903680,723900]]></RowHeight>
<ColumnWidth defaultValue="2743200">
<![CDATA[381000,1903680,1903680,1903680,1903680,1903680,1903680,1903680,2743200,2743200,2743200]]></ColumnWidth>
<CellElementList>
<C c="0" r="0" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="1" r="0" cs="2" s="1">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=now()]]></Attributes>
</O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="0" s="2">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=weekday(now())]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性1]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[2]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期二]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[3]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期三]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性3]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[4]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期四]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性4]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[5]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期五]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性5]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[6]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期六]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性6]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[7]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期日]]></O>
</HighlightAction>
</Highlight>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性7]]></Name>
<Condition class="com.fr.data.condition.ObjectCondition">
<Compare op="0">
<O t="I">
<![CDATA[1]]></O>
</Compare>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.ValueHighlightAction">
<O>
<![CDATA[星期一]]></O>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="0" s="0">
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="0" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="0" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="0" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="1" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="1" cs="2" s="4">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=now()]]></Attributes>
</O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="1" s="3">
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="2" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="2" s="5">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=weekday(todate(year(today()), month(today()), 1))]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性1]]></Name>
<Condition class="com.fr.data.condition.ListCondition"/>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.RowHeightHighlightAction"/>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="2" s="5">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=daysofmonth(today())]]></Attributes>
</O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="2" s="5">
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="3" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="3" s="6">
<O t="I">
<![CDATA[0]]></O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性1]]></Name>
<Condition class="com.fr.data.condition.ListCondition"/>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.RowHeightHighlightAction"/>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="3" s="6">
<O t="I">
<![CDATA[1]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="3" s="6">
<O t="I">
<![CDATA[2]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="3" s="6">
<O t="I">
<![CDATA[3]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="3" s="6">
<O t="I">
<![CDATA[4]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="3" s="6">
<O t="I">
<![CDATA[5]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="3" s="6">
<O t="I">
<![CDATA[6]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="4" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="4" s="7">
<O>
<![CDATA[日]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="2" r="4" s="7">
<O>
<![CDATA[一]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="3" r="4" s="7">
<O>
<![CDATA[二]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="4" s="7">
<O>
<![CDATA[三]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="4" s="7">
<O>
<![CDATA[四]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="4" s="7">
<O>
<![CDATA[五]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="4" s="7">
<O>
<![CDATA[六]]></O>
<PrivilegeControl/>
<Expand/>
</C>
<C c="0" r="5" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="5" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 = 0, 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="5" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 1, 1 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="3" r="5" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 2, 2 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="5" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 3, 3 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="5" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 4, 4 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="5" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 5, 5 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="5" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(B3 <= 6, 6 - B3 + 1, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="6" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="6" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 1]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="6" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 2]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="3" r="6" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 3]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="6" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 4]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="6" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 5]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="6" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 6]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="6" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H6 + 7]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="7" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="7" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 1]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="7" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 2]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand leftParentDefault="false" upParentDefault="false"/>
</C>
<C c="3" r="7" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 3]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="7" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 4]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="7" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 5]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="7" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 6]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="7" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H7 + 7]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="8" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="8" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 1]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="8" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 2]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand leftParentDefault="false" upParentDefault="false"/>
</C>
<C c="3" r="8" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 3]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="8" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 4]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="8" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 5]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="8" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 6]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="8" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H8 + 7]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="9" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="9" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H9 + 1]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="9" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=H9 + 2]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand leftParentDefault="false" upParentDefault="false"/>
</C>
<C c="3" r="9" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 3 <= C3, H9 + 3, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="4" r="9" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 4 <= C3, H9 + 4, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="5" r="9" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 5 <= C3, H9 + 5, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="6" r="9" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 6 <= C3, H9 + 6, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="7" r="9" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 7 <= C3, H9 + 7, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BorderHighlightAction">
<Border topLine="2" topColor="-16777216" bottomLine="2" bottomColor="-16777216" leftLine="2" leftColor="-16777216" rightLine="2" rightColor="-16777216"/>
</HighlightAction>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-3380951"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="0" r="10" s="0">
<PrivilegeControl/>
</C>
<C c="1" r="10" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 8 <= C3, H9 + 8, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-8078618"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="2" r="10" s="6">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=IF(H9 + 9 <= C3, H9 + 9, "")]]></Attributes>
</O>
<PrivilegeControl/>
<HighlightList>
<Highlight class="com.fr.report.cell.cellattr.highlight.DefaultHighlight">
<Name>
<![CDATA[条件属性2]]></Name>
<Condition class="com.fr.data.condition.FormulaCondition">
<Formula>
<![CDATA[day(today()) = $$$]]></Formula>
</Condition>
<HighlightAction class="com.fr.report.cell.cellattr.highlight.BackgroundHighlightAction">
<Background name="ColorBackground" color="-8078618"/>
</HighlightAction>
</Highlight>
</HighlightList>
<Expand/>
</C>
<C c="3" r="10" s="6">
<PrivilegeControl/>
<Expand/>
</C>
<C c="4" r="10" s="6">
<PrivilegeControl/>
<Expand/>
</C>
<C c="5" r="10" s="6">
<PrivilegeControl/>
<Expand/>
</C>
<C c="6" r="10" s="6">
<PrivilegeControl/>
<Expand/>
</C>
<C c="7" r="10" s="6">
<PrivilegeControl/>
<Expand/>
</C>
</CellElementList>
<ReportAttrSet>
<ReportSettings headerHeight="0" footerHeight="0">
<PaperSetting/>
</ReportSettings>
</ReportAttrSet>
</FormElementCase>
<StyleList>
<Style imageLayout="1">
<FRFont name="SimSun" style="0" size="72"/>
<Background name="ColorBackground" color="-11316397"/>
<Border/>
</Style>
<Style imageLayout="1">
<Format class="java.text.SimpleDateFormat">
<![CDATA[yyyy年MM月dd日]]></Format>
<FRFont name="Verdana" style="0" size="72" foreground="-3380951"/>
<Background name="ColorBackground" color="-11316397"/>
<Border/>
</Style>
<Style imageLayout="1">
<FRFont name="Verdana" style="0" size="72" foreground="-3380951"/>
<Background name="ColorBackground" color="-11316397"/>
<Border/>
</Style>
<Style imageLayout="1">
<FRFont name="Verdana" style="0" size="72"/>
<Background name="ColorBackground" color="-11316397"/>
<Border/>
</Style>
<Style imageLayout="1">
<Format class="java.text.SimpleDateFormat">
<![CDATA[yyyy年MM月]]></Format>
<FRFont name="Verdana" style="0" size="96" foreground="-1"/>
<Background name="ColorBackground" color="-11316397"/>
<Border/>
</Style>
<Style horizontal_alignment="0" imageLayout="1">
<FRFont name="Verdana" style="0" size="72"/>
<Background name="ColorBackground" color="-11316397"/>
<Border/>
</Style>
<Style horizontal_alignment="0" imageLayout="1">
<FRFont name="Verdana" style="0" size="88" foreground="-1"/>
<Background name="ColorBackground" color="-11316397"/>
<Border/>
</Style>
<Style horizontal_alignment="0" imageLayout="1">
<FRFont name="Verdana" style="1" size="88" foreground="-1"/>
<Background name="ColorBackground" color="-11316397"/>
<Border/>
</Style>
</StyleList>
<showToolbar showtoolbar="false"/>
<heightRestrict heightrestrict="false"/>
<heightPercent heightpercent="0.75"/>
<IM>
<![CDATA[[9@i<P\^0J(i"jR6V>=^A?2N#&2TVN`tDjC/5o0$BL0eD8Mi"sMNR7jI7]AG)dIKieO>J:!hS
t]AaNI@GnRH9i^]A^OVNSbI>W59KpLF$KDB?.\gtIBWNs/mFe5'bc]AA&J,Kb1]AGqG8jGZ2OFY-
@Sg=[38UNpVS:JCED.=f=K&=V"[Pk>>FiF,/`\i`!Q<<\cqoLK1T.ca_L0]A(2nFT?EB@Me4W
P<g`HG4*:FKg2jS8[B.2e<qc=(F2oB"858aUOg3P"RF#%5UZB9ZS#=Cm:llbdlB?c=P[&7kY
([qC:l:7J\V>M(B9lQQusB<-,3-VW!NO9s>g2K%HgKS.YY'Ba+oXTsR7lY"GaWPgK;+--1lh
JPNFb$>HdX7iO&l>-C6mhig'"iQ%$&#9ph?e'"h@arI^?rI#c2'"$_?^(lH%"!2A'9aZkRp3
2XBbq(6Rh`Fib1Al92Y.rlOC#^i!ci_]APr_AFoXdMlj4aeS?VQP&co`adocX4PqVc!(oCf3K
\i=bj;Ej04SbCR;m>"jbDJ4Ft,bCcK:\YgM_YmnRB\cpVK4ZW5@f@WkY+]A;ljLp\V><V=f"7
$:p2/PXXo/Te;ok::_-HWPCDM#m92;+lEV]A/q'/`"cg9QiC)`,B/9(8@hko0E01L?DLXL#.V
P66gi!0lV!C>EOhsl/sQYgds($]AXmlO<C`?QHD^'>l<":mKU58@CBJbn0F*pg$M5:%7dB4N(
2(UhPimse27Qigq(=Ok+^JNpEQAH-+##A*f)#MU&\Xj4sS(.&.Wo'-WLjiMLM'(Q^ZZog-q5
),78p`Pfj>Rn'LFLi=o^lWHoWO0Lm5$7Da2bVZ3=R,Ld5]AKW_gs3\IhF^M@%)=dANecM_[%\
+dVnlo<jOrdAdNcW1VfF7,ch0\WbG6Rf]A'P>:qa?Eq9c'#n6c&c]AKt)l^t?JKk.unEftqjAU
8Xo]Ak>Vb*).i3a8'4,I9,IBuUB#)gZjOGIqSXdA*ZYXtQ[EXAh+T(I5)PF0g@L-%'qgLdl[k
&f6NNTb"ei7M`im\)+$U;?guJ!mPDb[j42BCei.#Y`!FsUH'n/&k@R9i%I"SC_1V&P'60ugL
8K41RBs7EF\T+'lO,C]A"XXJ*t088UCZ9I?n#Ps>Q9nA<MRp\JSqLd1%LS>:srbr\(RjT\K1V
qJk+^VFmqgoHl>DQoJ7C"r?B>H!1f::lcT\#ARlp,4(^3%227C&,`;W*aAB3it2;m5*PZZ.1
tQ"=TF0C59)CeX5@#$R_S'O0f.'NIt@q8Po]A78&86MbK:G6V[[SdNd&7,Oi$gTq^#"^U"sPa
Lj>1N'=$+>#ZD0S2IhNAUE'/+;gHO]AR?@TAdTB1R=&K`Z'W82jaYZglC>^%R+ManGV+-]AN2?
5"_:N+M7]A<eEs/oi5Zdgq!XlPW:k3&jQnZXse+W-K=4#Q6&"MG9e+.(+14.1\EN-Ca.X_W*N
;s9`[.^KG96U^PPl@agdp%Q6V>c>rVnp1?fcoI[sFiU)tHb#2:HG4L2jk4VKlG[Y_;kp(+#:
\hoLM]Am)2<&i&$,mD:(ig5)Sg&XnH(t=%-&sm1SP=E8$N'+TlFATb`CPFfN,ch)OGk')%*W_
`#(/k2?]A5T@g&9X#&*H]Ak3)t>4HDH)*,R.r7jbS0qGX0qnMf!rKnam0%?J`&Da>=Ig]AM:e-r
&(a.o(N@Y0RF=l1SIVY0d?,<2_IM%R;mIUPMp6u$i^%;TT1-&c#C_a)@2Y.#2L6DZX/Nf";:
:D@>f3@N+dNS'Fp/V`L^o:cGF1)G]ASGD0R_H+.V9reOTH>DP;T*1.e86kC"@<^+T+Z%13V\U
i*0uhhDQIVbHa6#h8&3.>]A,6iaMf6F0Ou(+g_&`X<^;s2@frGo<;:Y75^,A:c&C9"6=,B-j-
uB(5Z#,-$7.CQN5N;!#7\__.#b_1Va@>&;F'9r4"fa]AD.Z-h(R(Je89UP)T/iHk!?>3]A&Z`[
dW'ZQCmr(/QnZZ[N8`$e92<9'Ycnt_poC@U[7+-!D@8!)T>0tK6lC[KqT<)HEo<TH'_m+K='
-e(eYqgM>T+'[5#ep,`-BAjg`QgE2gT6$K=tOh2D586H2;PjrpFZ$:Z#!/W:*2gJn]AoAhc<X
AW;8f7`K`TZYrb5a4Cnm+F%2aW.^4]A2]AZo9PXY^mLdV:I$kr]At'sSTSnU.d9;5Q[%:RJ8^DS
BT'F6D)M1CJpB^No'"UE06e?E9L@QeZp%bWX7id-%Ht#i:Nl=!NQ9A6(m=e@nXG]A[+&2(rjg
Kj=1H%e/2e+7(5:8#aLa$-]A9O&OjNI)^0N7)k?cTQQ`OnP/0`:*116j2P!7pl;Q_&!cMg5H,
q`L;\De>11"c)35[a=$PC'#UVM.ugF@RoZ8(\5@>7(RL=]A7b^8:R&dbc-XE4FBkg)U4$AhtC
#/=AafuZ(LDhH(QmGPmO_BPh0AA7FSn)#bV*EtFj,Rtm0D`Tb`[?3V7fG'XJ/r-)/j_C'pVO
uV%fcR>M*naKn3D7FC^j((E.Gc%#uWNh:oN[&\Le!:,FgeX_jjXF@<347[lOhbUcRTnYDSRe
-HGIB-R+&EI.J'T0^!(,pV'Td7`]Asi`K*iW:]A('p4nj6aHd*>-Hn2H9)(]AbW_(5u&_[OUf[+
lJn(At4:R?\WbrR_F1Q`4mroB$.Q#?)r+M#3`A%/:0ec%Ok/.PFJ^;>2Gpf\FI7*[W4Qq&,F
)nulLPIPZr9cENeqkn@3`4c".#gER$p*5,<3G,d6FDYi+enUTEf%=K^P__nQDU1(*%2Uc2m!
T+5XYpSb3?/F63%O,O["]AlLm,cnWj"PP7lSn_c)H:kY>O`pP/L$*9J\[fdn$'7ZP,[sITjkJ
kD[+X^K1tb?!N]AT3qs3.c*:lm-"M<\k=\Pn+D%]A8"r8s@bEa6H)?a_0B4V0RfG%2[">T__D>
OXBr\O09#;V-E%r;jVFaoMj=KN@29J:SJ+Oa(]AE&gd@sLW@+_OZnQWP*,'[u8Tepd0>6AjA^
Vo)RcbbI/gq*LVef,+g?mg$+,H!<8P7O!WS40`iX6b-$*?FSeUOt5*q^(b\5)*A$*@9]A#?f%
'O%)JseHGrCPeQ%iG!11'D'Cm6U.Qgn5ola,R>]A+&O0mkVDmGO4DMX(hgu)7tq#mRNI^k8nX
!k2r""3Je$:9.GRaOa**Bc0,P<Q/U68kYuoE)D=30u/*[34m9]ApD#6=qQbA%?ge6.QGV8]ACc
cBFDf+]A,&RVLdb.gbbt<fFX(+-S7<f]ACU*s(*j#VC+>4rFcA=p+W7qUTl/0&a:L;,854(jhm
pX;>.o%;[Gs%&QHbCHk%LYZo4;n<huSO+%6YY2G!@SNd6%k6;24!Ho2^kI7doE_cL:(mYK/R
(XA7qu@*RN-Qs$kZuRYk4*7<-B+^9;J]AejLaTZr(T[)(ltSI%tQ7.;P7U"dt3V?i0tQj$=%[
Oq)@QT?7..%12rH]Ar6Ma^<('sm,POrAH:sVKN;GcZpbS7<8O85sJe.FD3;cgNBCDUUl]AJIC7
;?50@^s1<c/\agPdjJAfAQ_c7/ZVsd]AM8Gkc"b)P$B@\@.WE<s4D@%@.g'/7VpR_b>al[:u2
[aiR=i#G&Xd.&%SdLjHT[q1]An1<[i\_m4t_nWAQF'r1OJFuJ+lIV1/flkGf7:MJb5CXBG>n8
Y6%:P\T=%#r!BIko;eq.!-:3I1Y:lN\k]A="*31tDJWHS!a'J`M-rn3]A)#,`C%:N20)`(;ehD
?bkFSaOA@AL2-1SL0]ARYQ)'H<mq.n1N'E`?>*R:@:`:0)7C?DHg'G:O1n<C%g_8\?#IEADZE
%[sXMg:YbrELR<;7^ME!*a!&u=1H0$s+3Oq6.mL_?[6u>^`7=KK;5[3Tr[>4;c&lWc<_fE_o
U@L45I9kiIeRAWmAl'rh9!dofn_\`K0">3I-:HlfKDM&N#EF!4kEqm+hI?eb\$@V^&+]A'4A9
g>IVB`QVPR'alg:6eoq'$-]A>lL"R@F>dG9sf4l@)Cc9j]AigYo/OkIo%4tO-+9W[A31o</kC)
/?c-L'eu(N@k$WIJe&^67j55_1`Wl=Xg%l(Lqik@<Jr7Ql%=">]A93C3s,G:J*!OZrei4"U\?
<+5%Lb9KanU_up(Nsj"#:XH>[l8+GSG&??j%_*1RRJ]AY'LITB?HSpd*Nbt!0pJ&Tu,+(1fjg
48l0A@Ik_i99,).UC)Re[f4<*<,)E"5Ac\k`a$L;a9B.)c<\?"uQDB^3?Qf:\8YsbUAh_nMX
ETSJ`9$4uY[?D]Aj![+YW7)H,@RdYPJ(bhBj.Za3SoOJLs54'!@TEiN6<G]AIHm6suW/;07"o5
Ff;N@pt#S=]A1E/PpSLVIFt4W)m)&=kY%KNFSZJiK8X<F-6B?5@=+)T"8Pk`V7]As-4^$)@M$o
ErF\GRp(BV5#sD%4-,<FBk`=_Rf"S#*BMV5IpaBE"gVP[K#,f2>h)j"/3QI[;fj]A6Qq6Z^NR
_Q)l1JVI=c`RIGSaQ+o^lrQrn9s?U9(\pQQ]A1l@J!-2)lerFDaMX:0,!:+I&sI,knC*qr"4l
!"Vbp<YSbsm&^"b!RBJ2RC\;T")09n^Xt=1TV'nTBqYJD(9;mKCGteG?YON**+,q1UjDpP!(
)Q?9`5SMH\I55PqSEt3g4kfRdXJaS*G&?E)%L>:/[!gAD+`b(C$"Ou["l=C+F:OT?"%WQkMW
kqcs/[iAc7QGq/4*#a[f^KEJ$`;Sn6%CAF3SGKdOS2G$29Cnq]Ap8G%mrBFrn$is!g\iD,/@2
Y`dPIc^]A.;i(GV#,XX%J,j(BmCCr>8&jCM+lLh4ugC:rRVY+1Z8)rpKR2FT?EU1u=2Ja'Y4O
,P]A*#hfla9H(>CcBP!-oepK/[4WiGm+Qm,TubAnKeMXd$!1Z;!rT9]AM:+9_cFc!n#0^0h]ABS
a,:e"q@.)4+UZbbef\[b/eL]Asaq9pgq*8s?Wm8dJuMBn&k#8_?2#MC=;C<,!pn]A>8))KVGj@
Mo%<U2^+h_1'^8D*7@";)0-_$[h)W!M?DO"f`7$[G%7kK(_C0q7juTgedf\C\aU_)N/cZf`Q
Sn.(c'n1<G$MY^&O5oZG$beaCP\W9^FjUf;W3n[Dlo+(Vqtf3d?!Y[Cp6L(?D67Lf>'bXZgl
MpBSZ@j"aN#Lso]ArB40VXB9X3A!At"]A2A:AnHm>C0'L`+Q:mC#XZXY]A+OoY=QMfc"esShjU3
K-!OBj^"lrW'd,7s'R_uPCY0?Um*8F[6hrR2@7X+2.6a-<9'p"(c#.c8A7P<+p-,URlqW8gu
g/`-4l_!fX<i+YWc"6Sf'd>lIFj3seBQ)QlCIb;UrTDkN/IuENrJumkGA!YmE:!1R*%_h7Rh
K,u;UqK#2R^/Y1XRt91r#Je/nQh/=rIVbaa0N-halQbQlkO_u(@75TfCdghg:,BCW\]A\7q3f
h9!r/rE$139dUN:<oDs&uYkNkK$XK0&%KN-k5^\k7SW<+n9L)0%r/<*EYU/(Mbo3K)AHSbHd
$/ipnAg7Z81kA;RNP5anhBXufO5:1jrRb!]A32B>YdfY98-iTrQTPn_=Q@Z)g2!N_>N<Dn!H@
[;F!Y5'Y3[?j9964\tn-qn?(\@--(t%-,;S.(&!_38/aUc)XWrI_Dj8(ZX3E\1?'t93p[MlM
m4BF\8@`qNf_3/aKG(mn)I!FQ;4AHCAEiQWA<HJ8YgYa9KM06nURkmsHknXW-;q8CZA<%fl2
g.EF!uEJ!_QAlHORurFPK/1@@!NoA927Y*Y8W!$4g>0PSK.>UK(4K5DqK6-bP7rEE#I$TFpU
?'[@hi@W9\3nYn(eSId<Ds%C4Fh"GQZmNs;<0,NWqkB(KeM5*Y#BbN4tuS+OkB#L,.D$Vq5k
o'N\FDd'5SSpm0Cn6fT71scd+>Q/OcdQ_DU<pJYNdJ*)*iNq9p/l:@aBOltUBO'2i-jl'<nZ
WspQt;9f_S7DU.u;1Nol\dIN?qDXYnLuF86%?BO.oZa!7*'"A/Tuh?.lbga.R[s`++SIgF#.
mfpYW!e/B&flLY!%aDijHYp]A;%=JQ^319:1T82dBHABPT,IVd894s.@J(38(L.i]AN9m9r5Rn
:&_oGN7&hGK]A.f!isbC.7Yl,l01Cnmq*ZP8,N4H\*X'MpDFEG6+IV/CUJ$rEu/(gHtB&OQge
ftAWlaG&%_do!\!%ne3ll#e958$k;$i("[\^7G81!I2"#.E!WW!]A\.!=e>o-+28luTMMR_>d
"1m\Po-/#C@nQfsSZhLuOP_C`:>;oS>7OJ$MX+Jh]A0dWL1Y(WMP%#R,$TFfP$aOo&IK0:SAd
-0@a0bD[&K?0NH1nLR\I*I_lfiAQ@CQX^8p^@p#AXn,`U-"@R.cr669K)<jud;tl7gcd[BPf
:MYi07fIYRt[N=ckc?gksreD`'Y"O:bJpFc#Q9KD+'f:VBR*<lN+J^UO?Y-@mJX-dk[WVeih
fT;6k\.K0O_h"$m;8[7C=%t$T&lB8ca=9[^*!eP@s[hDLI.5,AeTDbMm:C-q,7lu-@Z#0K?l
aHk@u?/)3hX,ej:LU:0U"7glk:ZW9fMWV/dpVSq3+<PQY#6\L9:m]A'`6.8aM3#);NTf_gp"L
,"pNc(U==SE^kd>H&OXB_``IOZ%0_=>c0um,T!Qg)Y8KO*k]AJip"[A;$ENY)V6(kNRe)iBKJ
jO9W`@LY='<Rd@0:"<O1fYNS\&1'a\e#=5RA%b7qX+Q\0HP1dXc72h;3NT`CZ.!CcgR!BF)W
4F4YQKBar[Ei[9j9IT.Z?Y'E5S%TpuW9o)t2S.TqQk1;cTft.(o+7i`;aQ:Bs+sAan#9cpuS
_K995Y\9?<reh\YNn`:!;n;+m5(s`hO>rH:4"hm#'nfR?FP4mT=n+oOXXIp`7\H!=Cc`Si'6
+XJ7!q0G[b5c]An/Jj%99cq^^$-InaF?YWSCYl0'N+Tb--f_VsehYReI>GoeA5]AIMA4fN/ah@
8(X\9/[iA*jQT_g0l/d`r.SCgU;O*9]AU\i,o6_G\4-Qt4<O@d.gh?^Uh)IhP.Re\^pJRIRY6
SrcG;mRk#_%-++#0d&)J2uMKh>mbF_G(,?5%"7fUI8e-Ib-@09Ae9MOAInp[2iN?>@FRIV=H
Pm&Zr^ZQ0?Q<c@cbbt!Flo"Wt?2W<P(b:''dpAmYVqE52`Heh4!ZAn@C@E6q>i`0B$LuEinT
OELj8Nct0eL-"(*t*#oQV9kI@+VMQ!O2Lq1@1\b<\n$5pCW("`\KfXf1pV(DnBc\!HT"T"`t
b7%0O5'B&SLEbMrianbcdbMcNm1cTXdJmM)=$V;=.On!nek<>Fu5&"ET*!nK7i4E>@$q`'rV
bhlK`96,dh*%Rhoo<h*i^*53aHCIN*(_8i_6L[X^*!<9foB<*4jfm`R%gr*_=?NVdf04\T%b
_I&C2Wt)]AP^!ebr`C.i1Cp8lHAe950e\,(D4Ho>2DAWIMX(_NI!;H5Wp7pCa$SX&G_1a1t?J
^L>Ncq^Xd#1h20.e_nd<e$o+Bi/EfaC43GY0]AJ=7)a]A8FkeUJ+9AJE7P>eEC&!A0ArpVUaC^
q\Qq2mp)16@Z:oc%BE:kuo9Pd?Sm5+Cbk-DYW*8lG'%<a.CT"*@a!E1r&=_8HAZErl*Y@hr)
k8If]A~
]]></IM>
<ElementCaseMobileAttrProvider horizontal="1" vertical="0" zoom="true" isUseHTML="false"/>
</body>
</InnerWidget>
<BoundsAttr x="0" y="0" width="640" height="803"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.container.WTitleLayout">
<WidgetName name="chart0"/>
<WidgetAttr>
<PrivilegeControl/>
</WidgetAttr>
<Margin top="0" left="0" bottom="0" right="0"/>
<Border>
<border style="0" color="-723724" type="0" borderStyle="0"/>
<WidgetTitle>
<O>
<![CDATA[新建标题]]></O>
<FRFont name="SimSun" style="0" size="72"/>
<Position pos="0"/>
</WidgetTitle>
<Alpha alpha="1.0"/>
</Border>
<LCAttr vgap="0" hgap="0" compInterval="0"/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.ChartEditor">
<WidgetName name="chart0"/>
<WidgetAttr>
<PrivilegeControl/>
</WidgetAttr>
<Margin top="0" left="0" bottom="0" right="0"/>
<Border>
<border style="0" color="-723724" type="0" borderStyle="0"/>
<WidgetTitle>
<O>
<![CDATA[新建标题]]></O>
<FRFont name="SimSun" style="0" size="72"/>
<Position pos="0"/>
</WidgetTitle>
<Alpha alpha="1.0"/>
</Border>
<LayoutAttr selectedIndex="0"/>
<Chart name="默认" chartClass="com.fr.plugin.chart.vanchart.VanChart">
<Chart class="com.fr.plugin.chart.vanchart.VanChart">
<GI>
<AttrBackground>
<Background name="NullBackground"/>
<Attr shadow="false"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="1" isRoundBorder="false" roundRadius="0"/>
<newColor borderColor="-3355444"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="1.0"/>
</AttrAlpha>
</GI>
<ChartAttr isJSDraw="true" isStyleGlobal="false"/>
<Title4VanChart>
<Title>
<GI>
<AttrBackground>
<Background name="ColorBackground" color="-1"/>
<Attr shadow="false"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="0"/>
<newColor borderColor="-6908266"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="0.75"/>
</AttrAlpha>
</GI>
<O>
<![CDATA[]]></O>
<TextAttr>
<Attr alignText="0">
<FRFont name="SimSun" style="0" size="128" foreground="-13421773"/>
</Attr>
</TextAttr>
<TitleVisible value="false" position="0"/>
</Title>
<Attr4VanChart useHtml="false" floating="false" x="0.0" y="0.0" limitSize="false" maxHeight="15.0"/>
</Title4VanChart>
<Plot class="com.fr.plugin.chart.map.VanChartMapPlot">
<GI>
<AttrBackground>
<Background name="NullBackground"/>
<Attr shadow="false"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="0"/>
<newColor/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="1.0"/>
</AttrAlpha>
</GI>
<Attr isNullValueBreak="true" autoRefreshPerSecond="0" seriesDragEnable="false" plotStyle="4" combinedSize="50.0"/>
<newHotTooltipStyle>
<AttrContents>
<Attr showLine="false" position="1" isWhiteBackground="true" isShowMutiSeries="false" seriesLabel="${VALUE}"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
<PercentFormat>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#0.##%]]></Format>
</PercentFormat>
</AttrContents>
</newHotTooltipStyle>
<ConditionCollection>
<DefaultAttr class="com.fr.chart.chartglyph.ConditionAttr">
<ConditionAttr name="">
<AttrList>
<Attr class="com.fr.plugin.chart.base.AttrBorderWithAlpha">
<AttrBorder>
<Attr lineStyle="1" isRoundBorder="false" roundRadius="0"/>
<newColor borderColor="-1"/>
</AttrBorder>
<AlphaAttr alpha="1.0"/>
</Attr>
<Attr class="com.fr.chart.base.AttrAlpha">
<AttrAlpha>
<Attr alpha="0.75"/>
</AttrAlpha>
</Attr>
<Attr class="com.fr.plugin.chart.map.attr.AttrMapLabel">
<AttrMapLabel>
<areaLabel class="com.fr.plugin.chart.base.AttrLabel">
<AttrLabel>
<labelAttr enable="false"/>
<labelDetail class="com.fr.plugin.chart.base.AttrLabelDetail">
<Attr showLine="false" position="5" isCustom="false"/>
<TextAttr>
<Attr alignText="0"/>
</TextAttr>
<AttrToolTipContent>
<Attr isCommon="true"/>
<value class="com.fr.plugin.chart.base.format.AttrTooltipMapValueFormat">
<AttrTooltipValueFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
</AttrTooltipValueFormat>
</value>
<percent class="com.fr.plugin.chart.base.format.AttrTooltipPercentFormat">
<AttrTooltipPercentFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##%]]></Format>
</AttrTooltipPercentFormat>
</percent>
<category class="com.fr.plugin.chart.base.format.AttrTooltipAreaNameFormat">
<AttrToolTipCategoryFormat>
<Attr enable="true"/>
</AttrToolTipCategoryFormat>
</category>
<series class="com.fr.plugin.chart.base.format.AttrTooltipSeriesFormat">
<AttrTooltipSeriesFormat>
<Attr enable="false"/>
</AttrTooltipSeriesFormat>
</series>
<HtmlLabel customText="" useHtml="false" isCustomWidth="false" isCustomHeight="false" width="50" height="50"/>
</AttrToolTipContent>
</labelDetail>
</AttrLabel>
</areaLabel>
<pointLabel class="com.fr.plugin.chart.base.AttrLabel">
<AttrLabel>
<labelAttr enable="false"/>
<labelDetail class="com.fr.plugin.chart.base.AttrLabelDetail">
<Attr showLine="false" position="5" isCustom="false"/>
<TextAttr>
<Attr alignText="0"/>
</TextAttr>
<AttrToolTipContent>
<Attr isCommon="true"/>
<value class="com.fr.plugin.chart.base.format.AttrTooltipMapValueFormat">
<AttrTooltipValueFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
</AttrTooltipValueFormat>
</value>
<percent class="com.fr.plugin.chart.base.format.AttrTooltipPercentFormat">
<AttrTooltipPercentFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##%]]></Format>
</AttrTooltipPercentFormat>
</percent>
<category class="com.fr.plugin.chart.base.format.AttrTooltipAreaNameFormat">
<AttrToolTipCategoryFormat>
<Attr enable="true"/>
</AttrToolTipCategoryFormat>
</category>
<series class="com.fr.plugin.chart.base.format.AttrTooltipSeriesFormat">
<AttrTooltipSeriesFormat>
<Attr enable="false"/>
</AttrTooltipSeriesFormat>
</series>
<HtmlLabel customText="" useHtml="false" isCustomWidth="false" isCustomHeight="false" width="50" height="50"/>
</AttrToolTipContent>
</labelDetail>
</AttrLabel>
</pointLabel>
</AttrMapLabel>
</Attr>
<Attr class="com.fr.plugin.chart.map.attr.AttrMapTooltip">
<AttrMapTooltip>
<areaTooltip class="com.fr.plugin.chart.base.AttrTooltip">
<AttrTooltip>
<Attr enable="true" followMouse="false" showMutiSeries="true" isCustom="false"/>
<TextAttr>
<Attr alignText="0"/>
</TextAttr>
<AttrToolTipContent>
<Attr isCommon="true"/>
<value class="com.fr.plugin.chart.base.format.AttrTooltipMapValueFormat">
<AttrTooltipValueFormat>
<Attr enable="true"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
</AttrTooltipValueFormat>
</value>
<percent class="com.fr.plugin.chart.base.format.AttrTooltipPercentFormat">
<AttrTooltipPercentFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##%]]></Format>
</AttrTooltipPercentFormat>
</percent>
<category class="com.fr.plugin.chart.base.format.AttrTooltipAreaNameFormat">
<AttrToolTipCategoryFormat>
<Attr enable="true"/>
</AttrToolTipCategoryFormat>
</category>
<series class="com.fr.plugin.chart.base.format.AttrTooltipSeriesFormat">
<AttrTooltipSeriesFormat>
<Attr enable="true"/>
</AttrTooltipSeriesFormat>
</series>
<HtmlLabel customText="" useHtml="false" isCustomWidth="false" isCustomHeight="false" width="50" height="50"/>
</AttrToolTipContent>
<GI>
<AttrBackground>
<Background name="ColorBackground" color="-16777216"/>
<Attr shadow="true"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="2"/>
<newColor borderColor="-16777216"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="0.5"/>
</AttrAlpha>
</GI>
</AttrTooltip>
</areaTooltip>
<pointTooltip class="com.fr.plugin.chart.base.AttrTooltip">
<AttrTooltip>
<Attr enable="true" followMouse="false" showMutiSeries="true" isCustom="false"/>
<TextAttr>
<Attr alignText="0"/>
</TextAttr>
<AttrToolTipContent>
<Attr isCommon="true"/>
<value class="com.fr.plugin.chart.base.format.AttrTooltipMapValueFormat">
<AttrTooltipValueFormat>
<Attr enable="true"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
</AttrTooltipValueFormat>
</value>
<percent class="com.fr.plugin.chart.base.format.AttrTooltipPercentFormat">
<AttrTooltipPercentFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##%]]></Format>
</AttrTooltipPercentFormat>
</percent>
<category class="com.fr.plugin.chart.base.format.AttrTooltipAreaNameFormat">
<AttrToolTipCategoryFormat>
<Attr enable="true"/>
</AttrToolTipCategoryFormat>
</category>
<series class="com.fr.plugin.chart.base.format.AttrTooltipSeriesFormat">
<AttrTooltipSeriesFormat>
<Attr enable="true"/>
</AttrTooltipSeriesFormat>
</series>
<HtmlLabel customText="" useHtml="false" isCustomWidth="false" isCustomHeight="false" width="50" height="50"/>
</AttrToolTipContent>
<GI>
<AttrBackground>
<Background name="ColorBackground" color="-16777216"/>
<Attr shadow="true"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="2"/>
<newColor borderColor="-16777216"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="0.5"/>
</AttrAlpha>
</GI>
</AttrTooltip>
</pointTooltip>
</AttrMapTooltip>
</Attr>
<Attr class="com.fr.plugin.chart.base.AttrMarkerAlpha">
<AttrAlpha>
<Attr alpha="1.0"/>
</AttrAlpha>
</Attr>
<Attr class="com.fr.plugin.chart.base.VanChartAttrMarker">
<VanAttrMarker>
<Attr isCommon="true" markerType="RoundFilledMarker" radius="4.5" width="30.0" height="30.0"/>
<Background name="NullBackground"/>
</VanAttrMarker>
</Attr>
<Attr class="com.fr.plugin.chart.base.AttrLabel">
<AttrLabel>
<labelAttr enable="false"/>
<labelDetail class="com.fr.plugin.chart.base.AttrLabelDetail">
<Attr showLine="false" position="5" isCustom="false"/>
<TextAttr>
<Attr alignText="0"/>
</TextAttr>
<AttrToolTipContent>
<Attr isCommon="true"/>
<value class="com.fr.plugin.chart.base.format.AttrTooltipMapValueFormat">
<AttrTooltipValueFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
</AttrTooltipValueFormat>
</value>
<percent class="com.fr.plugin.chart.base.format.AttrTooltipPercentFormat">
<AttrTooltipPercentFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##%]]></Format>
</AttrTooltipPercentFormat>
</percent>
<category class="com.fr.plugin.chart.base.format.AttrTooltipAreaNameFormat">
<AttrToolTipCategoryFormat>
<Attr enable="true"/>
</AttrToolTipCategoryFormat>
</category>
<series class="com.fr.plugin.chart.base.format.AttrTooltipSeriesFormat">
<AttrTooltipSeriesFormat>
<Attr enable="false"/>
</AttrTooltipSeriesFormat>
</series>
<HtmlLabel customText="" useHtml="false" isCustomWidth="false" isCustomHeight="false" width="50" height="50"/>
</AttrToolTipContent>
</labelDetail>
</AttrLabel>
</Attr>
</AttrList>
</ConditionAttr>
</DefaultAttr>
</ConditionCollection>
<Legend4VanChart>
<Legend>
<GI>
<AttrBackground>
<Background name="ColorBackground" color="-1"/>
<Attr shadow="true"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="2"/>
<newColor borderColor="-3355444"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="0.75"/>
</AttrAlpha>
</GI>
<Attr position="4" visible="false"/>
<FRFont name="SimSun" style="0" size="88" foreground="-10066330"/>
</Legend>
<Attr4VanChart floating="false" x="0.0" y="0.0" limitSize="false" maxHeight="15.0"/>
<Attr4VanChartScatter>
<Type rangeLegendType="1"/>
<GradualLegend>
<GradualIntervalConfig>
<IntervalConfigAttr subColor="-1495223" divStage="2.0"/>
<ValueRange IsCustomMin="false" IsCustomMax="false"/>
<ColorDistList>
<ColorDist color="-477505" dist="0.0"/>
<ColorDist color="-1019774" dist="0.093333334"/>
<ColorDist color="-1495223" dist="1.0"/>
</ColorDistList>
</GradualIntervalConfig>
<LegendLabelFormat>
<IsCommon commonValueFormat="true"/>
</LegendLabelFormat>
</GradualLegend>
</Attr4VanChartScatter>
</Legend4VanChart>
<DataSheet>
<GI>
<AttrBackground>
<Background name="NullBackground"/>
<Attr shadow="false"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="1" isRoundBorder="false" roundRadius="0"/>
<newColor borderColor="-16777216"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="1.0"/>
</AttrAlpha>
</GI>
<Attr isVisible="false"/>
</DataSheet>
<newPlotFillStyle>
<AttrFillStyle>
<AFStyle colorStyle="1"/>
<FillStyleName fillStyleName=""/>
<isCustomFillStyle isCustomFillStyle="true"/>
<ColorList>
<OColor colvalue="-3380951"/>
<OColor colvalue="-11184811"/>
<OColor colvalue="-4363512"/>
<OColor colvalue="-16750485"/>
<OColor colvalue="-3658447"/>
<OColor colvalue="-10331231"/>
<OColor colvalue="-7763575"/>
<OColor colvalue="-6514688"/>
<OColor colvalue="-16744620"/>
<OColor colvalue="-6187579"/>
<OColor colvalue="-15714713"/>
<OColor colvalue="-945550"/>
<OColor colvalue="-4092928"/>
<OColor colvalue="-13224394"/>
<OColor colvalue="-12423245"/>
<OColor colvalue="-10043521"/>
<OColor colvalue="-406154"/>
<OColor colvalue="-13031292"/>
<OColor colvalue="-16732559"/>
<OColor colvalue="-7099690"/>
<OColor colvalue="-11991199"/>
<OColor colvalue="-331445"/>
<OColor colvalue="-6991099"/>
<OColor colvalue="-16686527"/>
<OColor colvalue="-9205567"/>
<OColor colvalue="-7397856"/>
<OColor colvalue="-406154"/>
<OColor colvalue="-2712831"/>
<OColor colvalue="-4737097"/>
<OColor colvalue="-11460720"/>
<OColor colvalue="-6696775"/>
<OColor colvalue="-3685632"/>
</ColorList>
</AttrFillStyle>
</newPlotFillStyle>
<VanChartPlotAttr isAxisRotation="false"/>
<VanChartMapPlotAttr mapType="point" geourl="resources/geojson/point/中国.json" zoomlevel="0" mapmarkertype="1" nullvaluecolor="-3355444"/>
<GisLayer>
<Attr gislayer="mapbox"/>
</GisLayer>
<ViewCenter auto="true" longitude="0.0" latitude="0.0"/>
<pointConditionCollection>
<ConditionCollection>
<DefaultAttr class="com.fr.chart.chartglyph.ConditionAttr">
<ConditionAttr name=""/>
</DefaultAttr>
</ConditionCollection>
</pointConditionCollection>
</Plot>
<DataProcessor class="com.fr.base.chart.chartdata.model.NormalDataModel"/>
<ChartDefinition>
<VanMapDefinition>
<Top topCate="-1" topValue="-1" isDiscardOtherCate="false" isDiscardOtherSeries="false" isDiscardNullCate="false" isDiscardNullSeries="false"/>
<pointDefinition class="com.fr.plugin.chart.map.data.VanMapMoreNameCDDefinition">
<MoreNameCDDefinition>
<Top topCate="-1" topValue="-1" isDiscardOtherCate="false" isDiscardOtherSeries="false" isDiscardNullCate="false" isDiscardNullSeries="false"/>
<TableData class="com.fr.data.impl.NameTableData">
<Name>
<![CDATA[各个国家中产阶级人数]]></Name>
</TableData>
<CategoryName value="国家"/>
<ChartSummaryColumn name="人数" function="com.fr.data.util.function.NoneFunction" customName="人数"/>
</MoreNameCDDefinition>
<attr longitude="经度" latitude="纬度" useAreaName="false"/>
</pointDefinition>
</VanMapDefinition>
</ChartDefinition>
</Chart>
<tools hidden="true" sort="false" export="false" fullScreen="false"/>
<VanChartZoom>
<zoomAttr zoomVisible="false" zoomResize="true" zoomType="xy"/>
<from>
<![CDATA[]]></from>
<to>
<![CDATA[]]></to>
</VanChartZoom>
<refreshMoreLabel>
<TextAttr>
<Attr alignText="0">
<FRFont name="Microsoft YaHei" style="0" size="72"/>
</Attr>
</TextAttr>
 moreLabel="true" plusColor="-11349576" minusColor="-741051"</refreshMoreLabel>
</Chart>
</InnerWidget>
<BoundsAttr x="0" y="0" width="640" height="497"/>
</Widget>
<body class="com.fr.form.ui.ChartEditor">
<WidgetName name="chart0"/>
<WidgetAttr>
<PrivilegeControl/>
</WidgetAttr>
<Margin top="0" left="0" bottom="0" right="0"/>
<Border>
<border style="0" color="-723724" type="0" borderStyle="0"/>
<WidgetTitle>
<O>
<![CDATA[新建标题]]></O>
<FRFont name="SimSun" style="0" size="72"/>
<Position pos="0"/>
</WidgetTitle>
<Alpha alpha="1.0"/>
</Border>
<LayoutAttr selectedIndex="0"/>
<Chart name="默认" chartClass="com.fr.plugin.chart.vanchart.VanChart">
<Chart class="com.fr.plugin.chart.vanchart.VanChart">
<GI>
<AttrBackground>
<Background name="NullBackground"/>
<Attr shadow="false"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="1" isRoundBorder="false" roundRadius="0"/>
<newColor borderColor="-3355444"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="1.0"/>
</AttrAlpha>
</GI>
<ChartAttr isJSDraw="true" isStyleGlobal="false"/>
<Title4VanChart>
<Title>
<GI>
<AttrBackground>
<Background name="ColorBackground" color="-1"/>
<Attr shadow="false"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="0"/>
<newColor borderColor="-6908266"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="0.75"/>
</AttrAlpha>
</GI>
<O>
<![CDATA[]]></O>
<TextAttr>
<Attr alignText="0">
<FRFont name="Microsoft YaHei" style="0" size="128" foreground="-13421773"/>
</Attr>
</TextAttr>
<TitleVisible value="false" position="0"/>
</Title>
<Attr4VanChart useHtml="false" floating="false" x="0.0" y="0.0" limitSize="false" maxHeight="15.0"/>
</Title4VanChart>
<Plot class="com.fr.plugin.chart.map.VanChartMapPlot">
<GI>
<AttrBackground>
<Background name="NullBackground"/>
<Attr shadow="false"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="0"/>
<newColor/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="1.0"/>
</AttrAlpha>
</GI>
<Attr isNullValueBreak="true" autoRefreshPerSecond="0" seriesDragEnable="false" plotStyle="4" combinedSize="50.0"/>
<newHotTooltipStyle>
<AttrContents>
<Attr showLine="false" position="1" isWhiteBackground="true" isShowMutiSeries="false" seriesLabel="${VALUE}"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
<PercentFormat>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#0.##%]]></Format>
</PercentFormat>
</AttrContents>
</newHotTooltipStyle>
<ConditionCollection>
<DefaultAttr class="com.fr.chart.chartglyph.ConditionAttr">
<ConditionAttr name="">
<AttrList>
<Attr class="com.fr.plugin.chart.base.AttrBorderWithAlpha">
<AttrBorder>
<Attr lineStyle="1" isRoundBorder="false" roundRadius="0"/>
<newColor borderColor="-1"/>
</AttrBorder>
<AlphaAttr alpha="1.0"/>
</Attr>
<Attr class="com.fr.chart.base.AttrAlpha">
<AttrAlpha>
<Attr alpha="0.75"/>
</AttrAlpha>
</Attr>
<Attr class="com.fr.plugin.chart.map.attr.AttrMapLabel">
<AttrMapLabel>
<areaLabel class="com.fr.plugin.chart.base.AttrLabel">
<AttrLabel>
<labelAttr enable="false"/>
<labelDetail class="com.fr.plugin.chart.base.AttrLabelDetail">
<Attr showLine="false" position="5" isCustom="false"/>
<TextAttr>
<Attr alignText="0"/>
</TextAttr>
<AttrToolTipContent>
<Attr isCommon="true"/>
<value class="com.fr.plugin.chart.base.format.AttrTooltipMapValueFormat">
<AttrTooltipValueFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
</AttrTooltipValueFormat>
</value>
<percent class="com.fr.plugin.chart.base.format.AttrTooltipPercentFormat">
<AttrTooltipPercentFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##%]]></Format>
</AttrTooltipPercentFormat>
</percent>
<category class="com.fr.plugin.chart.base.format.AttrTooltipAreaNameFormat">
<AttrToolTipCategoryFormat>
<Attr enable="true"/>
</AttrToolTipCategoryFormat>
</category>
<series class="com.fr.plugin.chart.base.format.AttrTooltipSeriesFormat">
<AttrTooltipSeriesFormat>
<Attr enable="false"/>
</AttrTooltipSeriesFormat>
</series>
<HtmlLabel customText="" useHtml="false" isCustomWidth="false" isCustomHeight="false" width="50" height="50"/>
</AttrToolTipContent>
</labelDetail>
</AttrLabel>
</areaLabel>
<pointLabel class="com.fr.plugin.chart.base.AttrLabel">
<AttrLabel>
<labelAttr enable="false"/>
<labelDetail class="com.fr.plugin.chart.base.AttrLabelDetail">
<Attr showLine="false" position="5" isCustom="false"/>
<TextAttr>
<Attr alignText="0"/>
</TextAttr>
<AttrToolTipContent>
<Attr isCommon="true"/>
<value class="com.fr.plugin.chart.base.format.AttrTooltipMapValueFormat">
<AttrTooltipValueFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
</AttrTooltipValueFormat>
</value>
<percent class="com.fr.plugin.chart.base.format.AttrTooltipPercentFormat">
<AttrTooltipPercentFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##%]]></Format>
</AttrTooltipPercentFormat>
</percent>
<category class="com.fr.plugin.chart.base.format.AttrTooltipAreaNameFormat">
<AttrToolTipCategoryFormat>
<Attr enable="true"/>
</AttrToolTipCategoryFormat>
</category>
<series class="com.fr.plugin.chart.base.format.AttrTooltipSeriesFormat">
<AttrTooltipSeriesFormat>
<Attr enable="false"/>
</AttrTooltipSeriesFormat>
</series>
<HtmlLabel customText="" useHtml="false" isCustomWidth="false" isCustomHeight="false" width="50" height="50"/>
</AttrToolTipContent>
</labelDetail>
</AttrLabel>
</pointLabel>
</AttrMapLabel>
</Attr>
<Attr class="com.fr.plugin.chart.map.attr.AttrMapTooltip">
<AttrMapTooltip>
<areaTooltip class="com.fr.plugin.chart.base.AttrTooltip">
<AttrTooltip>
<Attr enable="true" followMouse="false" showMutiSeries="true" isCustom="false"/>
<TextAttr>
<Attr alignText="0"/>
</TextAttr>
<AttrToolTipContent>
<Attr isCommon="true"/>
<value class="com.fr.plugin.chart.base.format.AttrTooltipMapValueFormat">
<AttrTooltipValueFormat>
<Attr enable="true"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
</AttrTooltipValueFormat>
</value>
<percent class="com.fr.plugin.chart.base.format.AttrTooltipPercentFormat">
<AttrTooltipPercentFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##%]]></Format>
</AttrTooltipPercentFormat>
</percent>
<category class="com.fr.plugin.chart.base.format.AttrTooltipAreaNameFormat">
<AttrToolTipCategoryFormat>
<Attr enable="true"/>
</AttrToolTipCategoryFormat>
</category>
<series class="com.fr.plugin.chart.base.format.AttrTooltipSeriesFormat">
<AttrTooltipSeriesFormat>
<Attr enable="true"/>
</AttrTooltipSeriesFormat>
</series>
<HtmlLabel customText="" useHtml="false" isCustomWidth="false" isCustomHeight="false" width="50" height="50"/>
</AttrToolTipContent>
<GI>
<AttrBackground>
<Background name="ColorBackground" color="-16777216"/>
<Attr shadow="true"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="2"/>
<newColor borderColor="-16777216"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="0.5"/>
</AttrAlpha>
</GI>
</AttrTooltip>
</areaTooltip>
<pointTooltip class="com.fr.plugin.chart.base.AttrTooltip">
<AttrTooltip>
<Attr enable="true" followMouse="false" showMutiSeries="true" isCustom="false"/>
<TextAttr>
<Attr alignText="0"/>
</TextAttr>
<AttrToolTipContent>
<Attr isCommon="true"/>
<value class="com.fr.plugin.chart.base.format.AttrTooltipMapValueFormat">
<AttrTooltipValueFormat>
<Attr enable="true"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##]]></Format>
</AttrTooltipValueFormat>
</value>
<percent class="com.fr.plugin.chart.base.format.AttrTooltipPercentFormat">
<AttrTooltipPercentFormat>
<Attr enable="false"/>
<Format class="com.fr.base.CoreDecimalFormat">
<![CDATA[#.##%]]></Format>
</AttrTooltipPercentFormat>
</percent>
<category class="com.fr.plugin.chart.base.format.AttrTooltipAreaNameFormat">
<AttrToolTipCategoryFormat>
<Attr enable="true"/>
</AttrToolTipCategoryFormat>
</category>
<series class="com.fr.plugin.chart.base.format.AttrTooltipSeriesFormat">
<AttrTooltipSeriesFormat>
<Attr enable="true"/>
</AttrTooltipSeriesFormat>
</series>
<HtmlLabel customText="" useHtml="false" isCustomWidth="false" isCustomHeight="false" width="50" height="50"/>
</AttrToolTipContent>
<GI>
<AttrBackground>
<Background name="ColorBackground" color="-16777216"/>
<Attr shadow="true"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="2"/>
<newColor borderColor="-16777216"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="0.5"/>
</AttrAlpha>
</GI>
</AttrTooltip>
</pointTooltip>
</AttrMapTooltip>
</Attr>
</AttrList>
</ConditionAttr>
</DefaultAttr>
</ConditionCollection>
<Legend4VanChart>
<Legend>
<GI>
<AttrBackground>
<Background name="ColorBackground" color="-1"/>
<Attr shadow="true"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="0" isRoundBorder="false" roundRadius="2"/>
<newColor borderColor="-3355444"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="0.75"/>
</AttrAlpha>
</GI>
<Attr position="4" visible="true"/>
<FRFont name="Microsoft YaHei" style="0" size="88" foreground="-10066330"/>
</Legend>
<Attr4VanChart floating="false" x="0.0" y="0.0" limitSize="false" maxHeight="15.0"/>
<Attr4VanChartScatter>
<Type rangeLegendType="1"/>
<GradualLegend>
<GradualIntervalConfig>
<IntervalConfigAttr subColor="-14374913" divStage="2.0"/>
<ValueRange IsCustomMin="false" IsCustomMax="false"/>
<ColorDistList>
<ColorDist color="-4791553" dist="0.0"/>
<ColorDist color="-9583361" dist="0.5"/>
<ColorDist color="-14374913" dist="1.0"/>
</ColorDistList>
</GradualIntervalConfig>
<LegendLabelFormat>
<IsCommon commonValueFormat="true"/>
</LegendLabelFormat>
</GradualLegend>
</Attr4VanChartScatter>
</Legend4VanChart>
<DataSheet>
<GI>
<AttrBackground>
<Background name="NullBackground"/>
<Attr shadow="false"/>
</AttrBackground>
<AttrBorder>
<Attr lineStyle="1" isRoundBorder="false" roundRadius="0"/>
<newColor borderColor="-16777216"/>
</AttrBorder>
<AttrAlpha>
<Attr alpha="1.0"/>
</AttrAlpha>
</GI>
<Attr isVisible="false"/>
</DataSheet>
<newPlotFillStyle>
<AttrFillStyle>
<AFStyle colorStyle="1"/>
<FillStyleName fillStyleName="新特性"/>
<isCustomFillStyle isCustomFillStyle="false"/>
<ColorList>
<OColor colvalue="-10243346"/>
<OColor colvalue="-8988015"/>
<OColor colvalue="-472193"/>
<OColor colvalue="-486008"/>
<OColor colvalue="-8595761"/>
<OColor colvalue="-7236949"/>
<OColor colvalue="-8873759"/>
<OColor colvalue="-1071514"/>
<OColor colvalue="-1188474"/>
<OColor colvalue="-6715442"/>
<OColor colvalue="-10243346"/>
<OColor colvalue="-8988015"/>
<OColor colvalue="-472193"/>
<OColor colvalue="-486008"/>
<OColor colvalue="-8595761"/>
<OColor colvalue="-7236949"/>
<OColor colvalue="-8873759"/>
<OColor colvalue="-1071514"/>
<OColor colvalue="-1188474"/>
<OColor colvalue="-6715442"/>
<OColor colvalue="-10243346"/>
<OColor colvalue="-8988015"/>
<OColor colvalue="-472193"/>
<OColor colvalue="-486008"/>
<OColor colvalue="-8595761"/>
<OColor colvalue="-7236949"/>
<OColor colvalue="-8873759"/>
<OColor colvalue="-1071514"/>
<OColor colvalue="-1188474"/>
<OColor colvalue="-6715442"/>
<OColor colvalue="-10243346"/>
<OColor colvalue="-8988015"/>
</ColorList>
</AttrFillStyle>
</newPlotFillStyle>
<VanChartPlotAttr isAxisRotation="false"/>
<VanChartMapPlotAttr mapType="area" geourl="resources/geojson/area/中国(省级).json" zoomlevel="0" mapmarkertype="0" nullvaluecolor="-3355444"/>
<GisLayer>
<Attr gislayer="gaode"/>
</GisLayer>
<ViewCenter auto="true" longitude="0.0" latitude="0.0"/>
<pointConditionCollection>
<ConditionCollection>
<DefaultAttr class="com.fr.chart.chartglyph.ConditionAttr">
<ConditionAttr name=""/>
</DefaultAttr>
</ConditionCollection>
</pointConditionCollection>
</Plot>
<DataProcessor class="com.fr.base.chart.chartdata.model.NormalDataModel"/>
</Chart>
<tools hidden="true" sort="false" export="false" fullScreen="false"/>
<VanChartZoom>
<zoomAttr zoomVisible="false" zoomResize="true" zoomType="xy"/>
<from>
<![CDATA[]]></from>
<to>
<![CDATA[]]></to>
</VanChartZoom>
<refreshMoreLabel>
<TextAttr>
<Attr alignText="0">
<FRFont name="Microsoft YaHei" style="0" size="72"/>
</Attr>
</TextAttr>
 moreLabel="true" plusColor="-11349576" minusColor="-741051"</refreshMoreLabel>
</Chart>
</body>
</InnerWidget>
<BoundsAttr x="0" y="803" width="640" height="497"/>
</Widget>
<Sorted sorted="false"/>
<WidgetZoomAttr compState="0"/>
<AppRelayout appRelayout="true"/>
<Size width="640" height="1300"/>
<MobileWidgetList/>
</Center>
</Layout>
<DesignerVersion DesignerVersion="IAA"/>
<PreviewType PreviewType="0"/>
</Form>

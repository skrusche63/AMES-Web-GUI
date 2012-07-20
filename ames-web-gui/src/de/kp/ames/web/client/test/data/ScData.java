package de.kp.ames.web.client.test.data;

public class ScData {

    private String idSuffix;
    private ScNode[] data;

    public ScData(String idSuffix) {
        this.idSuffix = idSuffix;
    }

    private ScNode[] getData() {
        
    	if (data == null) {
            data = new ScNode[] {
            		
                new ScNode("Access", "new-category", "root", "silk/house.png", true, idSuffix),
                
                /*
                    new ExplorerTreeNode("Demo Application", "featured-complete-app", "featured-category", "silk/layout_content.png", new MiniAppSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Smart GWT MVC", "featured-smartgwt-mvc", "featured-category", "silk/arrow_join.png", new TreeEditingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid Cell Widgets", "featured-grid-cell-widgets", "featured-category", null, new GridCellWidgetsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Miller Columns", "featured-miller-columns", "featured-category", "silk/ipod.png", new MillerColumnsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Nested Grid", "featured-nested-grid", "featured-category", "crystal/16/mimetypes/widget_doc.png", new GridRowExpansionRelatedRecordsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Tile Sort &amp; Filtering", "featured-tile-filtering", "featured-category", "silk/application_view_tile.png", new FilterSortTilingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Print Grid", "featured-print-grid", "featured-category", "silk/printer.png", new PrintingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Adv. Filter Builder", "featured-filter-builder-grid", "featured-category", "crystal/oo/sc_insertformula.png", new GridNestedFilterBulderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Tree Grid", "featured-tree-grid", "featured-category", "silk/chart_organisation.png", new FrozenColumnsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid Header Spans", "featured-grid-header-span", "featured-category", null, new GridHeaderSpansSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Live Grid", "featured-grid-live", "featured-category", "silk/application_put.png", new LiveGridFetchSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Vertical Tabs", "featured-vertical-tabs", "featured-category", "silk/tab.png", new OrientationSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Calendar", "featured-databound-calendar-category", "featured-category", "crystal/16/apps/cal.png", new DataBoundCalendarSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dropdown Grid", "featured-dropdown-grid-category", "featured-category", "crystal/16/actions/completion.png", new DropdownListGridSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Dynamic Grouping", "featured-dynamic-grouping", "featured-category", "silk/application_side_tree.png", new GridDynamicGroupingSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Animation Playpen", "featured-animation-playpen", "featured-category", "silk/layers.png", new AnimationPlaypenSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Master Detail", "featured-master-detail", "featured-category", "silk/application_split.png", new GridFormUpdateSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("RestDataSource", "featured-restfulds", "featured-category", "silk/arrow_refresh_small.png", new RestfulDataSourceSample.Factory(), true, idSuffix),
                    //new ExplorerTreeNode("Yahoo! JSON Service", "featured-json-integration-category-yahoo", "featured-category", "crystal/16/apps/yahoo_protocol.png", new YahooJsonServicesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Pattern Reuse", "featured-pattern-reuse", "featured-category", "silk/database_table.png", new PatternReuseSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("XSD DataSource", "featured-xsd-ds", "featured-category", "silk/database_gear.png", new XsdDataSourceSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("GWT Integration", "featured-gwt-integration", "featured-category", "gwt/icon16.png", new GwtShowcaseSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Portal", "featured-portal", "featured-category", "silk/application_view_tile.png", new SimplePortalSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Databound Dragging", "grid-db-dragging-featured-category", "featured-category", "silk/database_link.png", new GridDataBoundDragDropSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Adaptive Filter", "grid-adaptive-filter-featured-category", "featured-category", "crystal/16/actions/show_table_row.png", new AdaptiveFilterSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Formula &amp; Summary Builder", "formula-sumamry-builder-featured-category", "featured-category", "crystal/oo/sc_insertformula.png", new FormulaSummaryBuilderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid Summaries", "grid-summaries-featured-category", "featured-category", "crystal/16/apps/tooloptions.png", new GridSummariesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Offline Preferences", "grid-offline-pref-featured-category", "featured-category", "crystal/16/apps/tooloptions.png", new OfflinePreferencesSample.Factory(), true, idSuffix),
				*/
                
                new ScNode("Bulletin", "new-category", "root", "silk/new.png", true, idSuffix)
                
                /*
                    new ExplorerTreeNode("Custom Cell Editors", "grid-custom-editing-cell-new", "new-category", null, new GridCellEditorCustomizerSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Expression Filter", "grid-exp-filter-new", "new-category", null, new GridExpressionFilter.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Multiline Summaries", "grid-ml-summaries-new", "new-category", "crystal/16/apps/tooloptions.png", new GridMultiLineSummariesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Grid Header Summaries", "grid-header-summaries-new", "new-category", "crystal/16/apps/tooloptions.png", new GridSummariesInHeaderSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Expression Filter", "grid-exp-filter-new", "new-category", null, new GridExpressionFilter.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Custom ListGrid Layout", "grid-components-new", "new-category", null, new GridComponentsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Preferences", "grid-appearance-preferences-new", "new-category", null, new GridPreferencesSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Shape Gallery", "shape-gallery-new", "new-category", null, new ShapeGallerySample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Rotation", "rotation-new", "new-category", null, new RotationSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Zoom and Pan", "zoom-and-pan-new", "new-category", null, new ZoomAndPanSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Lines and Arrowheads", "lines-and-arrowheads-new", "new-category", null, new LinesAndArrowheadsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Mouse Events", "mouse-events-new", "new-category", null, new DrawingMouseEventsSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Simple Gradient", "simple-gradient-new", "new-category", null, new SimpleGradientSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Linear Gradient", "linear-gradient-new", "new-category", null, new LinearGradientSample.Factory(), true, idSuffix),
                    new ExplorerTreeNode("Radial Gradient", "radial-gradient-new", "new-category", null, new RadialGradientSample.Factory(), true, idSuffix),
                    
                */
                
            };
        }
        return data;

    }

    public static ScNode[] getData(String idSuffix) {
        return new ScData(idSuffix).getData();
    }
    
}

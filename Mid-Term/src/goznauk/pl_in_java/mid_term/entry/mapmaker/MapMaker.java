package goznauk.pl_in_java.mid_term.entry.mapmaker;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created by goznauk on 2014. 8. 11..
 */
public class MapMaker {
    private MapMakerView view;
    private MapMakerModel model;
    private String mapPath;

    public MapMaker() {
    }

    public void init(String mapPath) {
        this.mapPath = mapPath;

        model = new MapMakerModel();
        if (setSize()) {
            view = new MapMakerView();
            view.init(model);
            view.setMapMakerViewCallbackEvent(mapMakerViewCallbackEvent);
        }
    }


    private MapMakerCallbackEvent mapMakerCallbackEvent;

    public void setMapMakerCallbackEvent(MapMakerCallbackEvent event) {
        mapMakerCallbackEvent = event;
    }


    MapMakerViewCallbackEvent mapMakerViewCallbackEvent = new MapMakerViewCallbackEvent() {
        @Override
        public void onMapChanged(int x, int y, boolean value) {

            if((x==0 && y==0) || (x==model.getWidth()-1 && y==model.getHeight()-1)) {
                view.setUnSelected(x, y);
                return;
            }

            model.setMapInfo(x, y, getBlockTypeByBoolean(value));
            model.printConsole();
        }

        @Override
        public void onSaveButtonClicked() {
            JFileChooser fileChooser = new JFileChooser(mapPath);

            FileNameExtensionFilter filter = new FileNameExtensionFilter("csv file", "csv");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showSaveDialog(view);
            if(result == JFileChooser.APPROVE_OPTION) {
                mapPath = fileChooser.getSelectedFile().toString() + ".csv";
                model.saveAsCsv(mapPath);
                mapMakerCallbackEvent.onMapSaved();
            }

        }

        @Override
        public void onViewClosed() {
            view.dispose();
        }
    };

    private boolean setSize() {
        JPanel mapConfigPanel = new JPanel();
        JTextField widthField = new JTextField(3);
        JTextField heightField = new JTextField(3);

        mapConfigPanel.add(new JLabel(" width : "));
        mapConfigPanel.add(widthField);
        mapConfigPanel.add(Box.createHorizontalStrut(15));
        mapConfigPanel.add(new JLabel("height : "));
        mapConfigPanel.add(heightField);

        int result = JOptionPane.showConfirmDialog(null, mapConfigPanel,
                "Please Enter Width and Height Values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("Width : " + widthField.getText());
            System.out.println("Height: " + heightField.getText());
            model.init(Integer.parseInt(widthField.getText()),
                        Integer.parseInt(heightField.getText()));
            return true;
        }
        return false;
    }

    private int getBlockTypeByBoolean(boolean b) {
        if(b) { return 1; }
        return 0;
    }

    public String getPath() {
        return mapPath;
    }
}
